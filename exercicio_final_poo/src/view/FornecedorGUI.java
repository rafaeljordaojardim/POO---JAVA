package view;

import Controller.Dados;
import model.Contato;
import model.Fornecedor;
import projectExceptions.MinhasExceptions;
import util.Auxiliar;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FornecedorGUI {
    private JTextField txtCodigoFornecedor;
    private JTextField txtRazao;
    private JTextField txtSocialFornecedor;
    private JTextField txtEnderecoFornecedor;
    private JTextField txtCidadeFornecedor;
    private JTextField txtEstadoFornecedor;
    private JButton btnIncluir;
    private JButton btnAlterar;
    private JButton btnConsultar;
    private JButton btnExcluir;
    private JPanel panelMain;
    private JComboBox cbxContatos;
    private JButton btnSalvar;
    private Dados dados;
    private int indexAlterar;

    public FornecedorGUI(Dados dados) {
        this.dados = dados;
        popularComboBox();
        btnIncluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                incluirFornecedor();
            }
        });
        btnConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (dados.getFornecedores().size() == 0) {
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semFornecedores());
                } else {
                    consultarFornecedor();
                }
            }
        });
        btnAlterar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (dados.getFornecedores().size() == 0) {
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semFornecedores());
                } else {
                    alterarDadosFornecedor();
                }
            }
        });
        btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                salvarDadosFornecedor();
            }
        });
        btnExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (dados.getFornecedores().size() == 0) {
                    Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.semFornecedores());
                } else {
                    excluirFornecedor();
                }

            }
        });
    }

    private void excluirFornecedor() {
        Fornecedor f = acharFornecedorPeloCod();
        if (f != null) {
            dados.getFornecedores().remove(f);
        }
    }

    private void salvarDadosFornecedor() {
        boolean verifica = verificaCamposBranco();
        if (!verifica) {
            try {
                String uf = txtEstadoFornecedor.getText();
                if (uf.length() != 2) {
                    throw new MinhasExceptions(3);
                }
                Contato contato = Auxiliar.pegaContatoNome(dados.getContatos(), cbxContatos.getSelectedItem().toString());
                Fornecedor fornecedor = new Fornecedor(Integer.parseInt(txtCodigoFornecedor.getText()),
                        txtRazao.getText(), txtSocialFornecedor.getText(),
                        txtEnderecoFornecedor.getText(), txtCidadeFornecedor.getText(),
                        txtEstadoFornecedor.getText(), contato);
                dados.getFornecedores().set(indexAlterar, fornecedor);
                limparCampos();
                Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
                habilitarDesabilitarSalvar(false);
            } catch (MinhasExceptions minhasExceptions) {
                minhasExceptions.printStackTrace();
            }

            txtCodigoFornecedor.setEnabled(true);
        }else{
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
        }

    }

    private void limparCodAndFocus() {
        txtCodigoFornecedor.setText("");
        txtCodigoFornecedor.requestFocus();
    }

    private void alterarDadosFornecedor() {
        Fornecedor f = acharFornecedorPeloCod();
        if (f != null) {
            txtCodigoFornecedor.setEnabled(false);
            txtCodigoFornecedor.setText(String.valueOf(f.getCodigo()));
            txtCidadeFornecedor.setText(f.getCidade());
            txtEnderecoFornecedor.setText(f.getEndereco());
            txtEstadoFornecedor.setText(f.getEstado());
            txtRazao.setText(f.getRazao());
            txtSocialFornecedor.setText(f.getSocial());
            cbxContatos.setSelectedItem(f.getContato().getNome());
            habilitarDesabilitarSalvar(true);
            txtCodigoFornecedor.setEnabled(false);
            indexAlterar = dados.getFornecedores().indexOf(f);
        }
    }

    public void habilitarDesabilitarSalvar(boolean b) {
        btnIncluir.setVisible(!b);
        btnExcluir.setVisible(!b);
        btnAlterar.setVisible(!b);
        btnConsultar.setVisible(!b);
        btnSalvar.setVisible(b);
    }

    private void consultarFornecedor() {
        Fornecedor fornecedor = acharFornecedorPeloCod();
        if (fornecedor != null) {
            Auxiliar.mensagem(Auxiliar.titleInformacao(), fornecedor.toString());
        }
    }

    private Fornecedor acharFornecedorPeloCod() {
        Fornecedor retorno = null;
        Object[] listaDeNomes = new Object[dados.getFornecedores().size()];
        for (int i = 0; i < dados.getFornecedores().size(); i++) {
            listaDeNomes[i] = dados.getFornecedores().get(i).getCodigo();
        }
        Object c = JOptionPane.showInputDialog(null, "Escolha um nome", "Contatos",
                JOptionPane.PLAIN_MESSAGE, null, listaDeNomes, "");
        if(c!=null){
            for (Fornecedor fornecedor : dados.getFornecedores()) {
                if (String.valueOf(fornecedor.getCodigo()).equalsIgnoreCase(c.toString())) {
                    retorno = fornecedor;
                }
            }
        }

        return retorno;
    }

    private void incluirFornecedor() {
        boolean verifica = verificaCamposBranco();
        if (!verifica) {
            try {
                int numero = Integer.parseInt(txtCodigoFornecedor.getText());
                String uf = txtEstadoFornecedor.getText();
                if (uf.length() != 2) {
                    throw new MinhasExceptions(3);
                }
                if (numero < 0) {
                    limparCodAndFocus();
                    throw new MinhasExceptions(2);
                }
                Contato c = Auxiliar.pegaContatoNome(dados.getContatos(), cbxContatos.getSelectedItem().toString());
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCidade(txtCidadeFornecedor.getText());
                fornecedor.setCodigo(numero);
                fornecedor.setEndereco(txtEnderecoFornecedor.getText());
                fornecedor.setEstado(uf.toUpperCase());
                fornecedor.setRazao(txtRazao.getText());
                fornecedor.setSocial(txtSocialFornecedor.getText());
                fornecedor.setContato(c);
                dados.getFornecedores().add(fornecedor);
                limparCampos();
                Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.mensagemIncluido());
            } catch (NumberFormatException e) {
                Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.digiteNumeroInteiro());
                limparCodAndFocus();
            } catch (MinhasExceptions minhasExceptions) {
                Auxiliar.mensagem(Auxiliar.titleInformacao(), minhasExceptions.getMessage());

            }
        }
    }

    private void limparCampos() {
        txtSocialFornecedor.setText("");
        txtRazao.setText("");
        txtEstadoFornecedor.setText("");
        txtEnderecoFornecedor.setText("");
        txtCidadeFornecedor.setText("");
        txtCodigoFornecedor.setText("");
        txtCodigoFornecedor.requestFocus();
    }

    private boolean verificaCamposBranco() {
        boolean retorno = false;
        if (txtCidadeFornecedor.getText().trim().equals("") || txtCidadeFornecedor.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtCidadeFornecedor.requestFocus();
        } else if (txtCodigoFornecedor.getText().trim().equals("") || txtCodigoFornecedor.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtCodigoFornecedor.requestFocus();
        } else if (txtRazao.getText().trim().equals("") || txtRazao.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtRazao.requestFocus();
        } else if (txtEnderecoFornecedor.getText().trim().equals("") || txtEnderecoFornecedor.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtEnderecoFornecedor.requestFocus();
        } else if (txtEstadoFornecedor.getText().trim().equals("") || txtEstadoFornecedor.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtEstadoFornecedor.requestFocus();
        } else if (txtSocialFornecedor.getText().trim().equals("") || txtSocialFornecedor.getText() == null) {
            retorno = true;
            Auxiliar.mensagem(Auxiliar.titleInformacao(), Auxiliar.preenchaTodosCampos());
            txtSocialFornecedor.requestFocus();
        }
        return retorno;
    }

    private void popularComboBox() {
        if (dados.getContatos() != null) {
            for (Contato c : dados.getContatos()) {
                cbxContatos.addItem(c.getNome());
            }
        }
    }

    public JPanel getPanelMain() {
        return panelMain;
    }


}
