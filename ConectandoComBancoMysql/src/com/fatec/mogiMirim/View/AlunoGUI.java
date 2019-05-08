package com.fatec.mogiMirim.View;

import com.fatec.mogiMirim.Controller.AlunoJDBC;
import com.fatec.mogiMirim.Model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AlunoGUI {
    AlunoJDBC alunoJDBC;

    public JPanel getPainelTotal() {
        return painelTotal;
    }

    private JPanel painelTotal;
    private JTextField txtNome;
    private JButton btnSalvar;


    public AlunoGUI() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    alunoJDBC = new AlunoJDBC();
                    salvarBanco();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void salvarBanco() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setNome(txtNome.getText());
        boolean retorno = alunoJDBC.salvarNome(aluno);
        mostrarMensagem(retorno);
        limpar();
    }

    private void mostrarMensagem(boolean b) {
        String msg;
        if (!b){
             msg = "Salvo no banco";

        }else{
            msg = "Não salvo no banco";
        }
        JOptionPane.showMessageDialog(null, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpar() {
        txtNome.setText("");
        txtNome.requestFocus();
    }
}
