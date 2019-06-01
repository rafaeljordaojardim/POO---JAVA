package view;

import javax.swing.*;

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
    private JButton Excluir;

    public JPanel getPanelMain() {
        return panelMain;
    }
}
