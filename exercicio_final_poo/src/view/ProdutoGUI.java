package view;

import Controller.Dados;
import model.Fornecedor;
import model.Produto;
import projectExceptions.MinhasExceptions;
import util.Auxiliar;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdutoGUI {
    private JTextField txtCodProduto;
    private JTextField txtDescricaoProduto;
    private JTextField txtPrecoProduto;
    private JPanel panelMain;
    private JTextField txtQuantidadeEstoqueProduto;
    private JComboBox cbxFornecedorProduto;
    private JButton btnIncluir;
    private JButton btnAlterar;
    private JButton btnConsultar;
    private JButton btnExcluir;
    private JButton btnSalvar;
    private Dados dados;
    private int indexAlterar;
    public JPanel getPanelMain() {
        return panelMain;
    }

    public ProdutoGUI(Dados dados) {
        this.dados = dados;
        popularComboBox();
        btnIncluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adicionarProduto();
            }
        });
        btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                salvarDados();
            }
        });
        btnConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                consultarProduto();
            }
        });
        btnExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                excluirProduto();
            }
        });
        btnAlterar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterarProduto();
            }
        });
    }

    private void excluirProduto() {
        Produto produto = acharProdutoPeloCod();
        if (produto != null){
            dados.getProdutos().remove(produto);
        }
    }//excluirProduto

    private void consultarProduto() {
        Produto produto = acharProdutoPeloCod();
        if (produto != null){
            Auxiliar.mensagem(Auxiliar.titleInformacao(), produto.toString());
        }
    }//consultarProduto

    private void salvarDados() {
        boolean verifica = verificaCamposBranco();
        if (!verifica){
            try{
                int quantidade = Integer.parseInt(txtQuantidadeEstoqueProduto.getText());
                float preco = Float.parseFloat(txtPrecoProduto.getText());
                if ( quantidade < 0 || preco < 0){
                    throw new MinhasExceptions(2);
                }
                Fornecedor fornecedor = Auxiliar.pegaFornecedorCod(dados.getFornecedores(), cbxFornecedorProduto.getSelectedItem().toString());
                if(fornecedor != null){
                    Produto produto = new Produto(Integer.parseInt(txtCodProduto.getText()), txtDescricaoProduto.getText(),
                            preco, quantidade, fornecedor);
                    dados.getProdutos().set(indexAlterar,produto);
                    habilitarDesabilitarSalvar(false);
                    txtCodProduto.setEnabled(true);
                    limparCampos();
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
                }else{
                    Auxiliar.mensagem(Auxiliar.titleInformacao(),Auxiliar.mensagemErro());
                }
            }catch (NumberFormatException e){
                Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.verifiqueCampos());

            }catch (MinhasExceptions minhasExceptions){
                Auxiliar.mensagem(Auxiliar.titleInformacao(), minhasExceptions.getMessage());
            }

        }//if
    }//salvarDados

    private void alterarProduto() {
        Produto produto = acharProdutoPeloCod();
        if (produto != null){
            txtCodProduto.setText(String.valueOf(produto.getCodigo()));
            txtDescricaoProduto.setText(String.valueOf(produto.getDescricao()));
            txtPrecoProduto.setText(String.valueOf(produto.getPreco()));
            txtQuantidadeEstoqueProduto.setText(String.valueOf(produto.getQuantidadeEstoque()));
            cbxFornecedorProduto.setSelectedItem(produto.getFornecedor().getCodigo());
            txtCodProduto.setEnabled(false);
            habilitarDesabilitarSalvar(true);
            indexAlterar = dados.getProdutos().indexOf(produto);
        }
    }//alterarProduto

    private void habilitarDesabilitarSalvar(boolean b) {
        btnIncluir.setVisible(!b);
        btnExcluir.setVisible(!b);
        btnAlterar.setVisible(!b);
        btnConsultar.setVisible(!b);
        btnSalvar.setVisible(b);
    }

    private void adicionarProduto() {
        boolean verifica = verificaCamposBranco();
        if (!verifica){
            try{
                int cod = Integer.parseInt(txtCodProduto.getText());
                int quantidade = Integer.parseInt(txtQuantidadeEstoqueProduto.getText());
                float preco = Float.parseFloat(txtPrecoProduto.getText());

                if (cod < 0 || quantidade < 0 || preco < 0){
                    throw new MinhasExceptions(2);
                }
                Fornecedor fornecedor = Auxiliar.pegaFornecedorCod(dados.getFornecedores(), cbxFornecedorProduto.getSelectedItem().toString());
                if(fornecedor != null){
                    Produto produto = new Produto(cod, txtDescricaoProduto.getText(),
                           preco, quantidade, fornecedor);
                    dados.getProdutos().add(produto);
                    limparCampos();
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
                }else{
                    Auxiliar.mensagem(Auxiliar.titleInformacao(),Auxiliar.mensagemErro());
                }
            }catch (NumberFormatException e){
                Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.verifiqueCampos());
            }catch (MinhasExceptions minhasExceptions){
                Auxiliar.mensagem(Auxiliar.titleInformacao(), minhasExceptions.getMessage());
            }
        }
    }//adicionarProduto

    private Produto acharProdutoPeloCod() {
        Produto retorno = null;
        Object[] listaDeCods = new Object[dados.getFornecedores().size()];
        for (int i = 0; i < dados.getProdutos().size(); i++) {
            listaDeCods[i] = dados.getProdutos().get(i).getCodigo();
        }
        Object c = JOptionPane.showInputDialog(null, "Escolha um código", "Produtos",
                JOptionPane.PLAIN_MESSAGE, null, listaDeCods, "");
        if(c!=null){
            for (Produto produto: dados.getProdutos()) {
                if (String.valueOf(produto.getCodigo()).equalsIgnoreCase(c.toString())) {
                    retorno = produto;
                }
            }
        }
        return retorno;
    }
    private void limparCampos() {
       txtCodProduto.setText("");
       txtQuantidadeEstoqueProduto.setText("");
       txtPrecoProduto.setText("");
       txtDescricaoProduto.setText("");
       txtCodProduto.requestFocus();
    }
    private boolean verificaCamposBranco() {
        boolean verifica = false;
        if (txtCodProduto.getText().trim().equalsIgnoreCase("") || txtCodProduto.getText() == null ){
            verifica = true;
            txtCodProduto.requestFocus();
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }else if(txtDescricaoProduto.getText().trim().equalsIgnoreCase("")|| txtDescricaoProduto.getText() == null){
            verifica = true;
            txtDescricaoProduto.requestFocus();
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }else if(txtPrecoProduto.getText().trim().equalsIgnoreCase("")|| txtPrecoProduto.getText() == null){
            verifica = true;
            txtPrecoProduto.requestFocus();
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        } else if(txtQuantidadeEstoqueProduto.getText().trim().equalsIgnoreCase("")|| txtQuantidadeEstoqueProduto.getText() == null){
            verifica = true;
            txtQuantidadeEstoqueProduto.requestFocus();
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }
        return verifica;
    }

    private void popularComboBox() {
        if (dados.getFornecedores() != null) {
            for (Fornecedor f: dados.getFornecedores()) {
                cbxFornecedorProduto.addItem(f.getCodigo());
            }
        }
    }

}
