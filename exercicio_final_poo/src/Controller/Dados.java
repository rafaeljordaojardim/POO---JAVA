package Controller;

import model.Cesta;
import model.Contato;
import model.Fornecedor;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private List<Fornecedor> fornecedores;
    private List<Contato> contatos;
    private Cesta cesta;
    private List<Produto> produtos;



    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    public Dados() {
        this.fornecedores = new ArrayList<>();
        this.contatos = new ArrayList<>();
        this.cesta = new Cesta();
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Dados(List<Fornecedor> fornecedores, List<Contato> contatos, Cesta cesta, List<Produto> produtos) {
        this.fornecedores = fornecedores;
        this.contatos = contatos;
        this.cesta = cesta;
        this.produtos = produtos;
    }
}
