package waiterdroidserver;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Classe da interface gráfica
public class Main extends javax.swing.JFrame {

    private DataModificacao dataMod;
    private String nomeArq = "DataModificacao.txt";
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Main() {
        initComponents();
    }

    //Gera o md5 da senha digitada pelo usuario
    public String md5(String s) throws NoSuchAlgorithmException{
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(s.getBytes()));
        return hash.toString(16);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lp1 = new javax.swing.JLayeredPane();
        pnCliente = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        lbEndereco = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        lbComplemento = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        tfUF = new javax.swing.JTextField();
        lbUF = new javax.swing.JLabel();
        Separador1 = new javax.swing.JSeparator();
        pfSenha = new javax.swing.JPasswordField();
        lbSenha = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        pfConfSenha = new javax.swing.JPasswordField();
        lbConfSenha = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        tfBairro = new javax.swing.JTextField();
        lbCidade1 = new javax.swing.JLabel();
        pnProduto = new javax.swing.JPanel();
        lbNomeProd = new javax.swing.JLabel();
        tfNomeProd = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        spDescricao = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btCadProd = new javax.swing.JButton();
        pnPedidos = new javax.swing.JPanel();
        spPedidos = new javax.swing.JScrollPane();
        taPedidos = new javax.swing.JTextArea();
        pnCancPedido = new javax.swing.JPanel();
        lbCancNum = new javax.swing.JLabel();
        cbCancNum = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        pnEntPedido = new javax.swing.JPanel();
        lbEntNum = new javax.swing.JLabel();
        cbEntNum = new javax.swing.JComboBox();
        btFinalizar = new javax.swing.JButton();
        mb1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miCadCli = new javax.swing.JMenuItem();
        miCadProd = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WaiterDroid");

        pnCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Cliente"));

        lbNome.setText("Nome Completo:");

        lbCPF.setText("CPF:");

        lbEndereco.setText("Endereço:");

        lbNumero.setText("Número:");

        lbComplemento.setText("Complemento:");

        lbCidade.setText("Cidade:");

        lbUF.setText("UF:");

        lbSenha.setText("Senha:");

        lbLogin.setText("Login:");

        lbConfSenha.setText("Confirma Senha:");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lbCidade1.setText("Bairro:");

        javax.swing.GroupLayout pnClienteLayout = new javax.swing.GroupLayout(pnCliente);
        pnCliente.setLayout(pnClienteLayout);
        pnClienteLayout.setHorizontalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Separador1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(pnClienteLayout.createSequentialGroup()
                        .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin)
                            .addComponent(lbSenha)
                            .addComponent(lbConfSenha))
                        .addGap(14, 14, 14)
                        .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(pfConfSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(tfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)))
                    .addGroup(pnClienteLayout.createSequentialGroup()
                        .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(lbCPF)
                            .addComponent(lbEndereco)
                            .addComponent(lbNumero)
                            .addComponent(lbComplemento)
                            .addComponent(lbCidade1)
                            .addComponent(lbCidade)
                            .addComponent(lbUF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUF, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(tfComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnClienteLayout.setVerticalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComplemento)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCidade1)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCidade)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUF)
                    .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConfSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btCadastrar)
                .addContainerGap())
        );

        pnCliente.setBounds(10, 0, 541, 520);
        lp1.add(pnCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar produto"));
        pnProduto.setVisible(false);

        lbNomeProd.setText("Nome: ");

        lbPreco.setText("Preço:");

        lbDescricao.setText("Descrição:");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        spDescricao.setViewportView(taDescricao);

        btCadProd.setText("Cadastrar");
        btCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnProdutoLayout = new javax.swing.GroupLayout(pnProduto);
        pnProduto.setLayout(pnProdutoLayout);
        pnProdutoLayout.setHorizontalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProdutoLayout.createSequentialGroup()
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPreco)
                            .addComponent(lbDescricao)
                            .addComponent(lbNomeProd))
                        .addGap(24, 24, 24)
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                            .addComponent(tfNomeProd, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                            .addComponent(tfPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
                    .addComponent(btCadProd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnProdutoLayout.setVerticalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeProd)
                    .addComponent(tfNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPreco)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(spDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCadProd)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pnProduto.setBounds(10, 0, 540, 520);
        lp1.add(pnProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));

        taPedidos.setColumns(20);
        taPedidos.setEditable(false);
        taPedidos.setRows(5);
        spPedidos.setViewportView(taPedidos);

        javax.swing.GroupLayout pnPedidosLayout = new javax.swing.GroupLayout(pnPedidos);
        pnPedidos.setLayout(pnPedidosLayout);
        pnPedidosLayout.setHorizontalGroup(
            pnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnPedidosLayout.setVerticalGroup(
            pnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPedidosLayout.createSequentialGroup()
                .addComponent(spPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnPedidos.setBounds(560, 0, 300, 320);
        lp1.add(pnPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnCancPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Cancelar Pedido:"));

        lbCancNum.setText("Número do Pedido:");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCancPedidoLayout = new javax.swing.GroupLayout(pnCancPedido);
        pnCancPedido.setLayout(pnCancPedidoLayout);
        pnCancPedidoLayout.setHorizontalGroup(
            pnCancPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCancPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCancPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCancPedidoLayout.createSequentialGroup()
                        .addComponent(lbCancNum)
                        .addGap(18, 18, 18)
                        .addComponent(cbCancNum, 0, 113, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCancPedidoLayout.createSequentialGroup()
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        pnCancPedidoLayout.setVerticalGroup(
            pnCancPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCancPedidoLayout.createSequentialGroup()
                .addGroup(pnCancPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCancNum)
                    .addComponent(cbCancNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnCancPedido.setBounds(560, 420, 300, 100);
        lp1.add(pnCancPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnEntPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar Pedido:"));

        lbEntNum.setText("Número do Pedido:");

        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnEntPedidoLayout = new javax.swing.GroupLayout(pnEntPedido);
        pnEntPedido.setLayout(pnEntPedidoLayout);
        pnEntPedidoLayout.setHorizontalGroup(
            pnEntPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEntPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEntPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEntPedidoLayout.createSequentialGroup()
                        .addComponent(lbEntNum)
                        .addGap(18, 18, 18)
                        .addComponent(cbEntNum, 0, 113, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEntPedidoLayout.createSequentialGroup()
                        .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        pnEntPedidoLayout.setVerticalGroup(
            pnEntPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEntPedidoLayout.createSequentialGroup()
                .addGroup(pnEntPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEntNum)
                    .addComponent(cbEntNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFinalizar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnEntPedido.setBounds(560, 320, 300, 100);
        lp1.add(pnEntPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Arquivo");

        miCadCli.setText("Cadastrar Cliente");
        miCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadCliActionPerformed(evt);
            }
        });
        jMenu1.add(miCadCli);

        miCadProd.setText("Cadastrar Produto");
        miCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadProdActionPerformed(evt);
            }
        });
        jMenu1.add(miCadProd);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        jMenu1.add(miSair);

        mb1.add(jMenu1);

        setJMenuBar(mb1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lp1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lp1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Atualiza os pedidos na tela
    public void atualizaPedidos() throws SQLException{
        pedidos = BD.getPedidosPendentes();
        String s = "";
        cbEntNum.removeAllItems();
        cbEntNum.addItem(" ");
        cbCancNum.removeAllItems();
        cbCancNum.addItem(" ");
        for(int i=0; i < pedidos.size();i++){
            cbEntNum.addItem(pedidos.get(i).getNumpedido());
            cbCancNum.addItem(pedidos.get(i).getNumpedido());
            s += "Número do pedido: "+pedidos.get(i).getNumpedido();
            s += "\n\nCliente: "+pedidos.get(i).getCliente();
            s += "\nMesa: "+pedidos.get(i).getMesa()+"\n\n";
            String[] aux = pedidos.get(i).getCarrinho().split("::");
            for(int j=0; j<aux.length; j++){
                Produto p = BD.buscarProduto(Integer.parseInt(aux[j].split(",")[0]));
                s += p.getNome()+"\n";
                s += "Quantidade: "+ aux[j].split(",")[1]+"\n\n";
            }
            s+="______________________\n\n";
        }
        taPedidos.setText(s);
    }

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        //Verifica se todos os campos foram preenchidos
        if(tfNome.getText().equals("") || tfCPF.getText().equals("") || tfEndereco.getText().equals("") ||
                tfNumero.getText().equals("") || tfBairro.getText().equals("") ||
                tfCidade.getText().equals("") || tfUF.getText().equals("") ||
                tfLogin.getText().equals("") || pfSenha.getText().equals("") || pfConfSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }else{
            //Confirma a senha digitada
            if(!pfSenha.getText().equals(pfConfSenha.getText())){
                JOptionPane.showMessageDialog(null, "Senha não confirmada");
            }else{
                //Verifica se o campo UF tem apenas 2 letras
                if(tfUF.getText().length() > 2)
                    JOptionPane.showMessageDialog(null, "O campo UF deve ter apenas 2 letras");
                else{
                    try{
                        Cliente c = new Cliente();
                        c.setNome(tfNome.getText());
                        c.setCpf(tfCPF.getText());
                        c.setEndereco(tfEndereco.getText());
                        c.setNumero(Integer.parseInt(tfNumero.getText()));
                        c.setCompl(tfComplemento.getText());
                        c.setBairro(tfBairro.getText());
                        c.setCidade(tfCidade.getText());
                        c.setUf(tfUF.getText());
                        c.setLogin(tfLogin.getText());
                        //Faz um md5 da senha
                        c.setSenha(md5(pfSenha.getText()));
                        BD bd = new BD(c);
                        if(bd.gravarCli() == 1){
                            //Limpa os campos
                            tfNome.setText("");
                            tfCPF.setText("");
                            tfEndereco.setText("");
                            tfNumero.setText("");
                            tfComplemento.setText("");
                            tfBairro.setText("");
                            tfCidade.setText("");
                            tfUF.setText("");
                            tfLogin.setText("");
                            pfSenha.setText("");
                            pfConfSenha.setText("");
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
                        }
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Digite um número inteiro no campo \"Número\"");
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o cliente\nErro: "+
                                e.toString());
                    }
                }
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void miCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadCliActionPerformed
        pnCliente.setVisible(true);
        pnProduto.setVisible(false);
    }//GEN-LAST:event_miCadCliActionPerformed

    private void miCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadProdActionPerformed
        pnCliente.setVisible(false);
        pnProduto.setVisible(true);
    }//GEN-LAST:event_miCadProdActionPerformed

    private void btCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadProdActionPerformed
        //Verifica se todos os campos foram preenchidos
        if(tfNomeProd.getText().equals("") || tfPreco.getText().equals("") ||
                taDescricao.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }else{

            try{
                Produto p = new Produto();
                p.setNome(tfNomeProd.getText());
                p.setPreco(Float.parseFloat(tfPreco.getText()));
                p.setDescricao(taDescricao.getText());

                BD bd = new BD(p);
                if(bd.gravarProd() == 1){
                    //Limpa os campos
                    tfNomeProd.setText("");
                    tfPreco.setText("");
                    taDescricao.setText("");
                    //Grava no arquivo a ultima modificação
                    dataMod = new DataModificacao();
                    Persiste.gravar(nomeArq, dataMod.getDataMod());
                    dataMod =  new DataModificacao((String)Persiste.ler(nomeArq));

                    JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um número no campo \"Preço\"");
            }
        }
    }//GEN-LAST:event_btCadProdActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        try {
            BD.alterarPedido(Integer.parseInt(cbEntNum.getSelectedItem().toString()), "FINALIZADO");
            JOptionPane.showMessageDialog(null, "O pedido foi finalizado");
            atualizaPedidos();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {
            BD.alterarPedido(Integer.parseInt(cbCancNum.getSelectedItem().toString()), "CANCELADO");
            JOptionPane.showMessageDialog(null, "O pedido foi cancelado");
            atualizaPedidos();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separador1;
    private javax.swing.JButton btCadProd;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JComboBox cbCancNum;
    private javax.swing.JComboBox cbEntNum;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCancNum;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCidade1;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbConfSenha;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbEntNum;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeProd;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUF;
    private javax.swing.JLayeredPane lp1;
    private javax.swing.JMenuBar mb1;
    private javax.swing.JMenuItem miCadCli;
    private javax.swing.JMenuItem miCadProd;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JPasswordField pfConfSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JPanel pnCancPedido;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnEntPedido;
    private javax.swing.JPanel pnPedidos;
    private javax.swing.JPanel pnProduto;
    private javax.swing.JScrollPane spDescricao;
    private javax.swing.JScrollPane spPedidos;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextArea taPedidos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeProd;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfUF;
    // End of variables declaration//GEN-END:variables

}
