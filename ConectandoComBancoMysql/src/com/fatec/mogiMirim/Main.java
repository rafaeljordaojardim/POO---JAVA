package com.fatec.mogiMirim;

import com.fatec.mogiMirim.View.AlunoGUI;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        JFrame tela = new JFrame("Cadastro de Alunos");
        tela.setContentPane(new AlunoGUI().getPainelTotal());
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setLocationRelativeTo(null);
        tela.setSize(400,400);
        tela.setVisible(true);


    }
}
