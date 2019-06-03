package view;

import model.Contato;
import util.Auxiliar;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ContatoGUI extends JFrame{
    private JTextField txtNomeContato;
    private JTextField txtTelefoneContato;
    private JTextField txtEmailContato;
    private JButton btnIncluirContato;
    private JButton btnAlterarContato;
    private JButton btnConsultarContato;
    private JButton btnExcluirContato;
    private JPanel panelMain;
    private JButton btnSalvar;
    private List<Contato> contatos;
    private int indexAlterar;

    public ContatoGUI(List<Contato> lista) {
        this.contatos = lista;
        indexAlterar = 0;
        btnIncluirContato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adicionarContato();
            }
        });
        btnConsultarContato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(contatos.size() > 0)
                    consultarContato();
                else
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semContatos());
            }
        });
        btnAlterarContato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(contatos.size() > 0)
                    alterarContato();
                else
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semContatos());

            }
        });
        btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                salvarDados();
            }
        });
        btnExcluirContato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(contatos.size() > 0)
                     excluirContato();
                else
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semContatos());
            }
        });
    }

    private void excluirContato() {
        Contato c = acharContatoPeloNome();
        if (c != null){
            contatos.remove(c);
        }
    }

    private void salvarDados() {
        boolean verifica = verificaAlgoEmBranco();
        if(verifica){
           Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }else{
            Contato c = new Contato(txtNomeContato.getText(), txtTelefoneContato.getText(), txtEmailContato.getText());
            contatos.set(indexAlterar, c);
            btnSalvar.setVisible(false);
            apagarTxt();
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
            habilitarDesabilitarSalvar(false);
        }
    }//salvarDados

    private boolean verificaAlgoEmBranco() {
        boolean retorno = false;
        if(txtNomeContato.getText().trim().equals("") || txtNomeContato.getText() == null){
            retorno = true;
            txtNomeContato.requestFocus();
        }else if(txtTelefoneContato.getText().trim().equals("") || txtTelefoneContato.getText() == null){
            retorno = true;
            txtTelefoneContato.requestFocus();
        }else if (txtEmailContato.getText().trim().equals("") || txtEmailContato.getText() == null) {
            retorno = true;
            txtEmailContato.requestFocus();
        }
        return retorno;
    }//verificaAlgoEmBranco

    private void alterarContato() {
        Contato c = acharContatoPeloNome();
        if(c != null){
            txtNomeContato.setText(c.getNome());
            txtTelefoneContato.setText(c.getTelefone());
            txtEmailContato.setText(c.getEmail());
            indexAlterar = contatos.indexOf(c);
            habilitarDesabilitarSalvar(true);
        }
    }//alterarContato

    private void habilitarDesabilitarSalvar(boolean b) {
        btnSalvar.setVisible(b);
        btnAlterarContato.setVisible(!b);
        btnConsultarContato.setVisible(!b);
        btnExcluirContato.setVisible(!b);
        btnIncluirContato.setVisible(!b);
    }

    private void consultarContato() {
        Contato c = acharContatoPeloNome();
        if (c != null){
            Auxiliar.mensagem(Auxiliar.titleInformacao(), c.toString());
        }
    }//consultarContato

    private Contato acharContatoPeloNome(){
        Contato retorno = null;
        Object[] listaDeNomes = new Object[contatos.size()];
        for (int i =0; i < contatos.size(); i ++) {
            listaDeNomes[i] = contatos.get(i).getNome();
        }
        Object c = JOptionPane.showInputDialog(null, "Escolha um nome" , "Contatos" ,
                JOptionPane.PLAIN_MESSAGE , null ,listaDeNomes,"");
        for (Contato contato : contatos) {
            if(contato.getNome().equals((String) c)){
               retorno = contato;
            }
        }
        return retorno;
    }//acharContatoPeloNome

    public JPanel getPanelMain() {
        return panelMain;
    }//getPanelMain

    private void adicionarContato() {
        boolean verifica = verificaAlgoEmBranco();
        if (verifica){
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }else{
            Contato contato = new Contato(txtNomeContato.getText(), txtTelefoneContato.getText(), txtEmailContato.getText());
            this.contatos.add(contato);
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
            this.apagarTxt();
        }
    }//adicionarContato


    private void apagarTxt(){
        txtNomeContato.setText("");
        txtEmailContato.setText("");
        txtTelefoneContato.setText("");
        txtNomeContato.requestFocus();
    }//apagarTxt

}//fim
