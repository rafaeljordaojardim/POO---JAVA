package view;

import Controller.Dados;
import model.Cesta;
import model.Contato;
import model.Fornecedor;
import model.Produto;
import util.Auxiliar;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal {
    private JButton btnFornecedor;
    private JButton btnProduto;
    private JButton btnSair;
    private JButton btnContato;
    private JPanel panelPrincipal;
    private Dados dados;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public TelaPrincipal() {
        this.dados = new Dados();
        btnContato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chamarTelaContato();
            }
        });
        btnFornecedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chamarTelaFornecedor();
            }
        });
    }

    private void chamarTelaFornecedor() {
        if(dados.getContatos().size() == 0){
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.adicioneContato());
        }else {
            JFrame tela = new JFrame("Fornecedor");
            tela.setContentPane(new FornecedorGUI(dados).getPanelMain());
            tela.setLocationRelativeTo(null);
            tela.setSize(630,350);
            tela.setVisible(true);
        }
    }

    private void chamarTelaContato() {
        JFrame tela = new JFrame("Contato");
        tela.setContentPane(new ContatoGUI(dados.getContatos()).getPanelMain());
        tela.setLocationRelativeTo(null);
        tela.setSize(400,400);
        tela.setVisible(true);
    }



}
