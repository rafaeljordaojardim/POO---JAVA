package com.company.GUI;

import com.company.Control.JogoDaVelhaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoVelhaGUI extends JFrame{
    private JogoDaVelhaController jogo;
    private JPanel panelJogo;

    public JPanel getPanelJogo() {
        return panelJogo;
    }

    private JButton btn1;
    private JButton btn4;
    private JButton btn7;
    private JButton btn2;
    private JButton btn8;
    private JButton btn5;
    private JButton btn3;
    private JButton btn6;
    private JButton btn9;
    private JButton btnReiniciar;
    private  JButton[] buttons;

    public JogoVelhaGUI() {
        jogo = new JogoDaVelhaController();
        buttons = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        ActionListener handlerClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerAlgoComOBotao(e);
            }
        };

        for (JButton button: buttons) {
            button.addActionListener(handlerClickListener);
        }
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo();
            }
        });
    }

    private void reiniciarJogo() {
        for (JButton button: buttons) {
            button.setText("Click");
            button.setEnabled(true);

        }
        jogo.setJogador("");
        jogo.setCont(0);
        jogo.setMatriz(new String[3][3]);
        jogo.setGanhou(false);
    }

    private void fazerAlgoComOBotao(ActionEvent e) {
        if(e.getSource()== btn1){
            jogar( 0, 0 ,btn1);
        }else if(e.getSource() == btn2){
            jogar(0, 1, btn2);
        }else if(e.getSource() == btn3){
            jogar(0, 2, btn3);
        }else if(e.getSource() == btn4){
            jogar(1, 0, btn4);
        }else if(e.getSource() == btn5){
            jogar(1, 1, btn5);
        }else if(e.getSource() == btn6){
            jogar(1, 2, btn6);
        }else if(e.getSource() == btn7){
            jogar(2, 0, btn7);
        }else if(e.getSource() == btn8){
            jogar(2, 1, btn8);
        }else if(e.getSource() == btn9){
            jogar(2, 2, btn9);
        }
    }

    private void jogar(int i, int i1, JButton btn) {
        if(jogo.getCont() % 2 ==0){
            jogo.setPositionMatriz(i, i1, " O");
            btn.setText("O");
            btn.setEnabled(false);
            jogo.setCont(jogo.getCont() + 1);
            jogo.setJogador("O");
        }else{
            jogo.setPositionMatriz(i, i1, "X");
            btn.setText("X");
            btn.setEnabled(false);
            jogo.setCont(jogo.getCont() + 1);
            jogo.setJogador("X");
        }
        if(jogo.getCont() >= 4){
            boolean ganhou = jogo.ganhou();
            if(ganhou){
                String msg = String.format("O jogador '%s' ganhou ", jogo.getJogador());
                JOptionPane.showMessageDialog(null, msg,"Jogo",JOptionPane.INFORMATION_MESSAGE);
                this.reiniciarJogo();
                jogo.setGanhou(false);
            }
        }
        if(jogo.getCont() >= 9 && (!jogo.isGanhou())){
            String msg = "Deu velha!";
            JOptionPane.showMessageDialog(null, msg,"Jogo",JOptionPane.INFORMATION_MESSAGE);
            this.reiniciarJogo();
            jogo.setGanhou(false);
        }
    }
}//JogoVelhaGUI
