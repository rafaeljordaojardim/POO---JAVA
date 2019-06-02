package Controller;

import model.Cesta;
import model.Contato;
import model.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private List<Fornecedor> fornecedores;
    private List<Contato> contatos;
    private Cesta cesta;



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
    }

    public Dados(List<Fornecedor> fornecedores, List<Contato> contatos, Cesta cesta) {
        this.fornecedores = fornecedores;
        this.contatos = contatos;
        this.cesta = cesta;
    }
}
