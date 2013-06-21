package waiterdroidserver;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Classe que salva as informações em arquivos montando um pequeno banco de dados
public class BD {
    private Cliente cliente = null;
    private Produto produto = null;
    private Pedido pedido = null;
    private static String arquivoCliente = "Cliente.txt";
    private static String arquivoProduto = "Produto.txt";
    private static String arquivoPedido = "Pedido.txt";

    public BD()
    {}

    public BD(Cliente c)
    {
        this.cliente = c;
    }

    public BD(Produto p){
        this.produto = p;
    }

    public BD(Pedido p){
        this.pedido = p;
    }

    public void setCliente(Cliente c){
        this.cliente = c;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public int gravarCli()
    {
        if(this.cliente == null)
            return 0;
        if(!Persiste.abrir(arquivoCliente)){
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientes.add(cliente);

            if(Persiste.gravar(arquivoCliente, clientes))
                return 1;
            else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
                return 0;
            }
        }else{
            List<Cliente> clientes = (ArrayList<Cliente>)Persiste.ler(arquivoCliente);
            for(int i=0; i < clientes.size() ;i++)
                if(clientes.get(i).getLogin().equals(cliente.getLogin())){
                    JOptionPane.showMessageDialog(null, "Login já existente");
                    return 0;
                }
            clientes.add(cliente);
            Persiste.gravar(arquivoCliente, clientes);
            return 1;
        }
     }//gravarCli

     public int gravarProd()
     {
        if(this.produto == null)
                return 0;

        if(!Persiste.abrir(arquivoProduto)){
            List<Produto> produtos = new ArrayList<Produto>();
            produto.setNum(1);
            produtos.add(produto);

            if(Persiste.gravar(arquivoProduto, produtos))
                return 1;
            else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto");
                return 0;
            }
        }else{
            List<Produto> produtos = (ArrayList<Produto>)Persiste.ler(arquivoProduto);
            int i;
            for(i=0; i < produtos.size() ;i++)
                if(produtos.get(i).getNome().equals(produto.getNome())){
                    JOptionPane.showMessageDialog(null, "Produto já cadastrado");
                    return 0;
                }
            i++;
            produto.setNum(i);
            produtos.add(produto);
            Persiste.gravar(arquivoProduto, produtos);
            return 1;
        }
    }//gravarProd

    public int gravarPedido()
    {
        if(this.pedido == null)
                return 0;
        if(!Persiste.abrir(arquivoPedido)){
            List<Pedido> pedidos = new ArrayList<Pedido>();
            pedido.setNumpedido(1);
            pedidos.add(pedido);

            if(Persiste.gravar(arquivoPedido, pedidos))
                return 1;
            else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar pedido");
                return 0;
            }
        }else{
            List<Pedido> pedidos = (ArrayList<Pedido>)Persiste.ler(arquivoPedido);
            
            pedido.setNumpedido(pedidos.size()+1);
            pedidos.add(pedido);
            Persiste.gravar(arquivoPedido, pedidos);
            return 1;
        }
    }//gravarPedido

    public static List<Produto> lerProd()
    {
        if(!Persiste.abrir(arquivoProduto))
            return new ArrayList<Produto>();
        return (ArrayList<Produto>) Persiste.ler(arquivoProduto);
    }//lerProd

    public static List<Cliente> lerCli()
    {
        if(!Persiste.abrir(arquivoCliente))
            return new ArrayList<Cliente>();
        return (ArrayList<Cliente>) Persiste.ler(arquivoCliente);
    }//lerCli

    public static String buscar(String login, String passwd) throws NoSuchAlgorithmException
    {
        if(!Persiste.abrir(arquivoCliente))
            return "";
        List<Cliente> clientes = (ArrayList<Cliente>) Persiste.ler(arquivoCliente);
        for(int i=0; i < clientes.size() ;i++)
            if(clientes.get(i).getLogin().equals(login)){
                String passDescrip = Criptografa.descriptografa(passwd, clientes.get(i).getSenha());
                String md5 = md5(passDescrip);
                if(md5.equals(clientes.get(i).getSenha()))
                    return md5;
                else
                    return "";
            }
        return "";
    }//buscar

    public static Produto buscarProduto(int numProd)
    {
        if(!Persiste.abrir(arquivoProduto))
            return new Produto();
        List<Produto> produtos = (ArrayList<Produto>) Persiste.ler(arquivoProduto);
        for(int i=0; i < produtos.size(); i++)
            if(produtos.get(i).getNum() == numProd)
                return produtos.get(i);
        return new Produto();
    }//buscarProduto

    public static List<Pedido> getPedidosPendentes()
    {
        if(!Persiste.abrir(arquivoPedido))
            return new ArrayList<Pedido>();

        List<Pedido> pedidos = (ArrayList<Pedido>) Persiste.ler(arquivoPedido);
	List<Pedido> pedidosPendentes = new ArrayList<Pedido>();
        for(int i=0; i < pedidos.size(); i++)
            if(pedidos.get(i).getStatus().equals("PENDENTE"))
                pedidosPendentes.add(pedidos.get(i));
        return pedidosPendentes;
    }//getPedidosPendentes

    public static void alterarPedido(int num, String status)
    {
        if(!Persiste.abrir(arquivoPedido))
            return;

        List<Pedido> pedidos = (ArrayList<Pedido>) Persiste.ler(arquivoPedido);
        for(int i=0; i < pedidos.size(); i++)
            if(pedidos.get(i).getNumpedido() == num){
                pedidos.get(i).setStatus(status);
                Persiste.gravar(arquivoPedido, pedidos);
            }
    }//alterar

    public static String md5(String s) throws NoSuchAlgorithmException{
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(s.getBytes()));
        return hash.toString(16);
    }

}
