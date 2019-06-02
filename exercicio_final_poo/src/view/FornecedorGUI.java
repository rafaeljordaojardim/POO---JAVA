package view;

import Controller.Dados;

import javax.swing.*;

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
    private Dados dados;

    public FornecedorGUI(Dados dados) {
        this.dados = dados;
    }


}
