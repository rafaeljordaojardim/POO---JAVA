package com.calc;

public class Jogador {
    //Atributos de classe

    //Atributos de instancia
    private int numero;
    private String nome;
    private int idade;
    private String posicao;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    //Construtores
    //Com parametros
    public Jogador(int numero, String nome, int idade, String posicao) {
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
    }//Jogador
    //Default
    public Jogador() {
        this.numero = 0;
        this.nome = "";
        this.idade = 0;
        this.posicao = "";
    }//Jogador
    //Cópia
    public Jogador(Jogador jogador) {
        this.numero = jogador.numero;
        this.nome = jogador.nome;
        this.idade = jogador.idade;
        this.posicao = jogador.posicao;
    }//Jogador


    //Método imprimir
    public String imprimir() {
        return "Jogador{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", posicao=" + posicao +
                '}';
    }
    //Cadastrar jogador
    public void cadastrarJogador(int numero, String nome, int idade, String posicao) {
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
    }//Jogador



}//Jogador
