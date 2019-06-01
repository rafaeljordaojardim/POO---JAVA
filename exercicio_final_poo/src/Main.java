import view.ProdutoGUI;
import view.TelaPrincipal;

import javax.swing.*;


public class Main {


    public static void main(String[] args) {
        JFrame tela = new JFrame("Produtos");
        tela.setContentPane(new TelaPrincipal().getPanelPrincipal());
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setLocationRelativeTo(null);
        tela.setSize(400,400);

        tela.setVisible(true);

    }
}
