package com.calc;

import java.util.ArrayList;

public class Time {
    //Atributos de classe
    private static final int TAMANHO_TIME = 6;

    //Atributos de instancia
    private int id;
    private String nome;
    private ArrayList<Jogador> jogadores;

    public static int getTamanhoTime() {
        return TAMANHO_TIME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getJogador(int index){
        return jogadores.get(index);
    }

    public Jogador setJogador(int index, Jogador jogador){
        return jogadores.set(index, jogador);
    }

    //Construtores
    public Time(int id, String nome, ArrayList<Jogador> jogadores) {
        this.id = id;
        this.nome = nome;
        this.jogadores = jogadores;
    }//Time
    public Time() {
        this.id = 0;
        this.nome = "";
        this.jogadores = new ArrayList<>();
    }//Time




    //Cadastrar time
    public void cadastrarTime(int id, String nome, ArrayList<Jogador> jogadores){
        this.id = id;
        this.nome = nome;
        this.jogadores = jogadores;
    }//cadastrarTime


    //Listar jogadores
    public String listarJogadores(){
        String retorno = "";
        if(jogadores.size() == 0)
            retorno = "Não Há Jogadores neste time";
        else
            for (Jogador umJogador:jogadores ) retorno += "\n" + umJogador.imprimir() +"\n";
        return retorno;
    }
}//Time
