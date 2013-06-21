package waiterdroidserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class Servidor extends Thread {
        private Socket socket;
        private String nomeArq = "DataModificacao.txt";
        private DataModificacao dataMod;
        private static Main m;

        public Servidor(Socket socket) {
            this.socket = socket;
        }

        public static void main(String args[]) throws SQLException {
            //Troca o LookAndFeel
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //----------------------------------------------------------
             

            try {
                //Inicia um servidor socket
                ServerSocket server = new ServerSocket(5436);

                //Chama a interface grafica
                m = new Main();
                m.setVisible(true);
                m.atualizaPedidos();
                //O servidor fica escutando a porta 5555 para novas conexoes
                while (true) {
                    Socket conexao = server.accept();
                    Thread t = new Servidor(conexao);
                    t.start();
                }
            } catch (IOException e) {
            }
        }

        public void run() {
            //Verifica se o arquivo com a data de modificação existe.
            //Caso não exista, é criado um novo arquivo
            if(!Persiste.abrir(nomeArq)){
                Persiste.gravar(nomeArq, new DataModificacao().getDataMod());
            }

            try {
                //Prepara para receber e enviar mensagens ao cliente
                ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());

                //Pega a mensagem contendo o login e a senha
                String s = (String) in.readObject();

                //separa o login da senha
                String[] msg = s.split("::_::");
                //------------------------------------------------------------
                String login = msg[0];
                String senha = msg[1];
                //Verifica se a mensagem estava vazia
                if (login == null || login.equals("")) {
                    this.socket.close();
                    return;
                }
                //Verifica o login e a senha
                String md5 = BD.buscar(login, senha);
                if(md5.equals("")) {
                    //Manda uma mensagem de erro para o cliente
                    send(out, "100");
                    System.out.println("Problemas ao efetuar o login");
                    this.socket.close();
                    return;
                }

                //Manda uma mensagem de ok para o cliente
                send(out, "200");
                //manda a data da ultima atualização no banco
                dataMod = new DataModificacao((String)Persiste.ler(nomeArq));
                send(out, dataMod.getDataMod());

                //Recebe mensagens do cliente
                msg = ((String)in.readObject()).split("::_::");
                while (msg != null && !(msg[0].trim().equals("000"))) {
                    //Verifica se o cliente está pedindo a lista de produtos
                    if(msg[0].equals("300")){
                        //Pega os produtos
                        List<Produto> produtos = BD.lerProd();
                        for(int i=0; i< produtos.size(); i++){
                            //Confirma o inicio do envio
                            send(out, "200");
                            //Envia uma String com os dados
                            String produto = "";
                            produto = produtos.get(i).getNome();
                            produto += "::_::"+ produtos.get(i).getNum();
                            produto += "::_::"+ produtos.get(i).getPreco();
                            produto += "::_::"+ produtos.get(i).getDescricao();
                            send(out, produto);
                        }
                        //Envia mensagem confirmando o envio
                        send(out, "201");
                    }
                    //Verifica se o cliente está enviando o pedido
                    if(msg[0].equals("301")){
                        //Recebe o pedido
                        msg = ((String)in.readObject()).split("::_::");
                        //Descriptografa a mensagem
                        String aux = Criptografa.descriptografa(msg[0], md5);
                        //Separa a mensagem
                        msg = aux.split("::_::");

                        //Cria um novo pedido
                        Pedido p = new Pedido();
                        p.setCliente(login);
                        p.setMesa(msg[0]);
                        p.setCarrinho(msg[1]);
                        p.setStatus("PENDENTE");

                        BD bd = new BD(p);
                        if(bd.gravarPedido() == 1){
                            //Envia mensagem confirmando o envio
                            send(out, "200");
                            m.atualizaPedidos();
                            JOptionPane.showMessageDialog(null, "Novo pedido!!!");
                        }else{
                            //Envia mensagem confirmando o envio
                            send(out, "100");
                        }
                    }
                    msg = ((String)in.readObject()).split("::_::");
                }


                this.socket.close();
            } catch (Exception e) {
                if(!this.socket.isClosed())
                    try {
                        this.socket.close();
                    } catch (IOException ex) {
                    }
                System.out.println("Falha na Conexao... .. ." + " Exception: " + e);
            }
        }//run()

        private void send(ObjectOutputStream out, Object msg){
            try {
                out.flush();
                out.writeObject(msg);
            } catch (IOException ex) {
                System.err.println("Erro ao comunicar com o cliente");
            }

        }
}
