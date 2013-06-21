package waiterdroidserver;

import java.io.Serializable;

//Classe com os dados dos clientes que serão salvos no arquivo
public class Cliente implements Serializable{
    private String nome, cpf, endereco, compl, bairro,
                    cidade, uf, login, senha;
    private int numero;

    public Cliente(String nome, String cpf, String endereco, String compl, String bairro,
            int numero, String cidade, String uf, String login, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.compl = compl;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.login = login;
        this.senha = senha;
    }

    public Cliente(){

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
