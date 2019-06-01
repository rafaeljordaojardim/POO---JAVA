package model;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
    //atributos
    private List<Produto> itens;

    //Acessores
    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public Cesta(List<Produto> itens) {
        this.itens = itens;
    }

    public Produto getItem(int index){
        return itens.get(index);
    }
    public void setItem(int index, Produto produto){
        itens.set(index, produto);
    }

    //Construtores
    public Cesta() {
        this.itens = new ArrayList<>();
    }

    //metodos
    public void adicionarItem(Produto p){
        itens.add(p);
    }

    public float calcTotal(){
        float retorno = 0;
        for (Produto p: itens)
            retorno+=p.getPreco();
        return retorno;
    }

}
