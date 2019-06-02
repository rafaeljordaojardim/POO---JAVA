package view;

import Controller.Dados;
import model.Cesta;
import model.Contato;
import model.Fornecedor;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class TelaPrincipal {
    private JButton btnFornecedor;
    private JButton btnProduto;
    private JButton btnSair;
    private JButton btnContato;
    private JPanel panelPrincipal;
    private Dados dados;

    public TelaPrincipal() {
        this.dados = new Dados();
    }



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
