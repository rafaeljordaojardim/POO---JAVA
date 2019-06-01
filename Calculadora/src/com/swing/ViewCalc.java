package com.swing;

import com.calc.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ViewCalc {
    private JButton btnIgual;
    private JPanel panelMain;
    private JPanel panelBotoes;
    private JButton btnSoma;
    private JButton btnSubtracao;
    private JButton btnmultiplicacao;
    private JButton btnDivisao;
    private JPanel panelDoDisplay;
    private JTextField txtPrimeiroCampo;
    private JTextField txtResultado;
    private JPanel panelResultado;
    private JButton btnLimpar;
    private JButton btn2;
    private JButton btn1;
    private JButton btn6;
    private JButton btn8;
    private JButton btn5;
    private JButton btn7;
    private JButton btn9;
    private JButton btn4;
    private JButton btn3;
    private JButton btn0;
    private String operacao;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public ViewCalc() {
        btnSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao = "+";
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "+");
            }
        });
        btnSubtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao="-";
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "-");
            }
        });
        btnmultiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao="*";
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "*");
            }
        });
        btnDivisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacao = "/";
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "/");
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeros[];
                String oQueFazer = txtPrimeiroCampo.getText();
                if(operacao == null || operacao.equals(""))
                    txtResultado.setText("ERROR");
                else
                    if(oQueFazer == null || oQueFazer.trim().equals(""))
                        txtResultado.setText("ERROR");
                else{
                    numeros = oQueFazer.split(Pattern.quote(operacao));
                    double n1 = Double.parseDouble(numeros[0]);
                    double n2 = Double.parseDouble(numeros[1]);
                    double resultado = 0.0;
                    Calculator calc = new Calculator();
                    switch (operacao){
                        case "+":
                                resultado = calc.doSoma(n1, n2);
                            break;
                        case "-":
                                resultado = calc.doSub(n1, n2);
                            break;
                        case "*":
                                resultado = calc.doMult(n1, n2);
                            break;
                        case "/":
                                resultado = calc.doDiv(n1, n2);
                            break;
                    }
                   montarApresentacao(resultado);

                }
            }//actionPerformed
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                txtPrimeiroCampo.setText("");
                txtPrimeiroCampo.requestFocus();
                operacao = "";
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeiroCampo.setText(txtPrimeiroCampo.getText() + "0");
            }
        });
    }//ViewCalc

    private void montarApresentacao(double resultado) {
        int resultadoInt = (int) resultado;
        txtResultado.setText(String.valueOf(resultadoInt));
    }


}
