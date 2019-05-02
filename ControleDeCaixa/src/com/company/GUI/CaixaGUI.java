package com.company.GUI;

import com.company.Business.Caixa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CaixaGUI extends JFrame implements ActionListener, WindowListener {
    protected Dimension dLabel, dFrame, dTextField, dTextArea, dButton;
    protected Label labelValor;
    protected Label labelSaldo;
    protected TextField txtValor;
    protected TextField txtSaldo;
    protected Button btnEntrada;
    protected Button btnRetirada;
    protected Button btnConsulta;
    protected Button btnSair;
    protected TextArea textMsg;

    protected Caixa caixa;

    public CaixaGUI(){
        //Instanciar uma caixa
        caixa = new Caixa();
        //Definir a aparencia da jenela
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        dFrame = new Dimension(350, 400);
        this.setSize(dFrame);
        this.setResizable(false);
        this.setTitle("Controle de Caixa");
        this.setLayout(null);

        //definir os atributos
        dLabel = new Dimension(40, 20);

        labelValor = new Label("Valor: ");
        labelValor.setSize(dLabel);
        labelValor.setLocation(25, 50);
        this.add(labelValor);

        labelSaldo = new Label("Saldo");
        labelSaldo.setSize(dLabel);
        labelSaldo.setLocation(25, 80);
        this.add(labelSaldo);

        dTextField = new Dimension(150, 20);
        txtValor = new TextField(null);
        txtValor.setSize(dTextField);
        txtValor.setLocation(75, 50);
        this.add(txtValor);

        txtSaldo = new TextField(null);
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75, 80);
        this.add(txtSaldo);

        dButton = new Dimension(95, 20);

        btnEntrada = new Button("Depositar");
        btnEntrada.setSize(dButton);
        btnEntrada.setLocation(25, 150);
        this.add(btnEntrada);
        btnEntrada.addActionListener(this);


        btnConsulta = new Button("Consultar");
        btnConsulta.setSize(dButton);
        btnConsulta.setLocation(25, 180);
        this.add(btnConsulta);
        btnConsulta.addActionListener(this);


        btnRetirada = new Button("Retirar");
        btnRetirada.setSize(dButton);
        btnRetirada.setLocation(180, 150);
        this.add(btnRetirada);
        btnRetirada.addActionListener(this);


        btnSair = new Button("Sair");
        btnSair.setSize(dButton);
        btnSair.setLocation(180, 185);
        btnSair.addActionListener(this);
        this.add(btnSair);

        dTextArea = new Dimension(300, 140);
        textMsg = new TextArea(null);
        textMsg.setSize(dTextArea);
        textMsg.setLocation(25, 220);
        this.add(textMsg);


        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSair){
            String msg = "Finalizando o Caixa!";
            JOptionPane.showMessageDialog(null, msg, "Fim", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if(e.getSource() == btnEntrada){
            double valor = Double.parseDouble(txtValor.getText());
            String retorno = caixa.depositar(valor);
            textMsg.append(retorno + "\n");
            txtValor.setText(null);
            txtValor.requestFocus();
        }
        if(e.getSource() == btnConsulta){
            txtSaldo.setText(String.valueOf(caixa.getSaldo()));
            txtValor.requestFocus();
        }
        if(e.getSource() == btnRetirada){
            double valor = Double.parseDouble(txtValor.getText());
            String retorno = caixa.sacar(valor);
            textMsg.append(retorno + "\n");
            txtValor.setText(null);
            txtValor.requestFocus();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
