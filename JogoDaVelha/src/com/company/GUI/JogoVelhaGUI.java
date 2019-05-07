package com.company.GUI;

import com.company.Control.JogoDaVelhaController;

import javax.swing.*;
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
        buttons = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        reiniciarJogo();
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
            button.setText("");
            button.setEnabled(true);
        }
       jogo = new JogoDaVelhaController();
    }

    private void fazerAlgoComOBotao(ActionEvent e) {
        if(e.getSource() == btn1){
            jogar( btn1);
        }else if(e.getSource() == btn2){
            jogar(btn2);
        }else if(e.getSource() == btn3){
            jogar(btn3);
        }else if(e.getSource() == btn4){
            jogar(btn4);
        }else if(e.getSource() == btn5){
            jogar(btn5);
        }else if(e.getSource() == btn6){
            jogar(btn6);
        }else if(e.getSource() == btn7){
            jogar( btn7);
        }else if(e.getSource() == btn8){
            jogar(btn8);
        }else if(e.getSource() == btn9){
            jogar(btn9);
        }
    }

    private void jogar(JButton btn) {
        if(jogo.getCont() % 2 == 0){
            btn.setText("O");
            btn.setEnabled(false);
            jogo.setCont(jogo.getCont() + 1);
            //textArea1.append(String.format("O jogador '%s' jogou no botão [%s, %s]\n", jogo.getJogador(), String.valueOf(i), String.valueOf(i1)));
        }else {
            btn.setText("X");
            btn.setEnabled(false);
            jogo.setCont(jogo.getCont() + 1);
            // textArea1.append(String.format("O jogador '%s' jogou no botão [%s, %s]\n", jogo.getJogador(), String.valueOf(i), String.valueOf(i1)));
        }
            boolean ganhou = verificandoGanhador();
            if(ganhou){
                String msg = String.format("O jogador '%s' ganhou \n", jogo.getJogador());
                JOptionPane.showMessageDialog(null, msg,"Jogo",JOptionPane.INFORMATION_MESSAGE);
                this.reiniciarJogo();
                jogo.setGanhou(false);
            }

        if(jogo.getCont() >= 9 && (!jogo.isGanhou())){
            String msg = "Deu velha!";
            JOptionPane.showMessageDialog(null, msg,"Jogo",JOptionPane.INFORMATION_MESSAGE);
            this.reiniciarJogo();
            jogo.setGanhou(false);
        }
    }

    private boolean verificandoGanhador() {
        boolean ganhou = false;
        if (!btn1.isEnabled() && !btn5.isEnabled() && !btn9.isEnabled()) {
            if (btn1.getText().equals(btn5.getText()) && btn5.getText().equals(btn9.getText())) {
                ganhou = true;
                jogo.setJogador(btn1.getText());
            }
        } else if (!btn3.isEnabled() && !btn5.isEnabled() && !btn7.isEnabled()) {
            if (btn3.getText().equals(btn5.getText()) && btn5.getText().equals(btn7.getText())) {
                ganhou = true;
                jogo.setJogador(btn3.getText());

        }
        }else if (!btn1.isEnabled() && !btn2.isEnabled() && !btn3.isEnabled()) {
            if (btn1.getText().equals(btn2.getText()) && btn2.getText().equals(btn3.getText())) {
                ganhou = true;
                jogo.setJogador(btn1.getText());

            }
        }else if (!btn4.isEnabled() && !btn5.isEnabled() && !btn6.isEnabled()) {
            if (btn4.getText().equals(btn5.getText()) && btn5.getText().equals(btn6.getText())) {
                ganhou = true;
                jogo.setJogador(btn4.getText());

            }
        }else if (!btn7.isEnabled() && !btn8.isEnabled() && !btn9.isEnabled()) {
            if (btn7.getText().equals(btn8.getText()) && btn8.getText().equals(btn9.getText())) {
                ganhou = true;
                jogo.setJogador(btn8.getText());

            }
        }else if (!btn1.isEnabled() && !btn4.isEnabled() && !btn7.isEnabled()) {
            if (btn1.getText().equals(btn4.getText()) && btn4.getText().equals(btn7.getText())) {
                ganhou = true;
                jogo.setJogador(btn1.getText());

            }
        }else if (!btn2.isEnabled() && !btn5.isEnabled() && !btn8.isEnabled()) {
            if (btn2.getText().equals(btn5.getText()) && btn5.getText().equals(btn8.getText())) {
                ganhou = true;
                jogo.setJogador(btn2.getText());

            }
        }else if (!btn3.isEnabled() && !btn6.isEnabled() && !btn9.isEnabled()) {
            if (btn3.getText().equals(btn6.getText()) && btn6.getText().equals(btn9.getText())) {
                ganhou = true;
                jogo.setJogador(btn3.getText());

            }
        }
        return ganhou;
    }



}//JogoVelhaGUI
