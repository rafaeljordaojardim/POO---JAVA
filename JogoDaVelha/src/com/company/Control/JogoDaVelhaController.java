package com.company.Control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelhaController {

    private int cont;
    private String[][] matriz;
    private String jogador;
    private boolean ganhou;

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public boolean isGanhou() {
        return ganhou;
    }

    public void setGanhou(boolean ganhou) {
        this.ganhou = ganhou;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }


    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public JogoDaVelhaController() {
        cont = 0;
        matriz = new String[3][3];
    }


    public void setPositionMatriz(int x, int y, String n){
        matriz[x][y] = n;
    }

    public boolean ganhou() {
        if(matriz[0][0]!=null && matriz[0][1] != null && matriz[0][2] != null){
            if(matriz[0][0].equals(matriz[0][1]) && matriz[0][1].equals(matriz[0][2])) {
                ganhou = true;
                this.setJogador(matriz[0][0]);
            }
        }else if(matriz[1][0]!= null && matriz[1][1]!= null &&matriz[1][2] != null) {
            if (matriz[1][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[1][2])){
                ganhou = true;
                this.setJogador(matriz[1][0]);
            }
        }else if(matriz[2][0]!= null && matriz[2][1]!= null&& matriz[2][2]!= null){
            if (matriz[2][0].equals(matriz[2][1]) && matriz[2][1].equals(matriz[2][2])){
                ganhou = true;
                this.setJogador(matriz[2][0]);
            }
        }else if(matriz[0][0]!=null&&matriz[1][0]!=null&&matriz[2][0]!=null){
                if(matriz[0][0].equals(matriz[1][0]) && matriz[1][0].equals(matriz[2][0])) {
                    ganhou = true;
                    this.setJogador(matriz[0][0]);
                }
        }else if(matriz[0][1]!=null&&matriz[1][1]!=null&&matriz[2][1]!=null){
            if (matriz[0][1].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][1])){
                ganhou = true;
                this.setJogador(matriz[0][1]);
            }
        }else if(matriz[0][2]!=null&&matriz[1][2]!=null&&matriz[2][2]!=null){
            if(matriz[0][2].equals(matriz[1][2]) && matriz[1][2].equals(matriz[2][2])){
                ganhou = true;
                this.setJogador(matriz[0][2]);
            }
        }
            if (matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
                ganhou = true;
                this.setJogador(matriz[0][0]);
            }
            if (matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])){
                ganhou = true;
                this.setJogador(matriz[0][2]);
            }

            return ganhou;
    }
}
