package com.company.Control;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelhaController {

    private int cont;
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


    public JogoDaVelhaController() {
        cont = 0;
        ganhou = false;
        jogador = "";
    }


    public boolean ganhou(JButton[] buttons) {
        //boolean ganhou = false;
        if (!buttons[0].isEnabled() && !buttons[1].isEnabled() && !buttons[2].isEnabled()) {
            if (buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[1].getText())) {
                ganhou = true;
                this.setJogador(buttons[0].getText());
                return true;
            }
        } else if (!buttons[3].isEnabled() && !buttons[4].isEnabled() && !buttons[5].isEnabled()) {
            if (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())) {
                ganhou = true;
                this.setJogador(buttons[3].getText());
                return true;
            }
        } else if (!buttons[6].isEnabled() && !buttons[7].isEnabled() && !buttons[8].isEnabled()) {
            if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())) {
                ganhou = true;
                this.setJogador(buttons[6].getText());
                return true;
            }
        } else if (!buttons[0].isEnabled() && !buttons[3].isEnabled() && !buttons[6].isEnabled()) {
            if (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText())) {
                ganhou = true;
                this.setJogador(buttons[0].getText());
                return true;
            }
        } else if (!buttons[1].isEnabled() && !buttons[4].isEnabled() && !buttons[7].isEnabled()) {
            if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())) {
                ganhou = true;
                this.setJogador(buttons[1].getText());
                return true;
            }
        } else if (!buttons[2].isEnabled() && !buttons[6].isEnabled() && !buttons[8].isEnabled()) {
            if (buttons[2].getText().equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[8].getText())) {
                ganhou = true;
                this.setJogador(buttons[2].getText());
                return true;
            }
        }
        return false;

    }
}
