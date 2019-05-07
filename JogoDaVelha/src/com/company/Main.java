package com.company;

import com.company.GUI.JogoVelhaGUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Alunos");
        tela.setContentPane(new JogoVelhaGUI().getPanelJogo());
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setLocationRelativeTo(null);
        tela.setSize(400,400);
        tela.setVisible(true);
    }
}
