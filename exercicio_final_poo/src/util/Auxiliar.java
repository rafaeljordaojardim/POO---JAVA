package util;

import javax.naming.Context;
import javax.swing.*;

public class Auxiliar {

    public static String mensagemIncluido(){
        return "Incluido com sucesso!";
    }

    public static String titleInformacao(){
        return "Informação";
    }
    public static String mensagemErro(){
        return "Algo deu errado!";
    }
    public static void mensagem(String title, String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, title,JOptionPane.INFORMATION_MESSAGE);
    }//

    public static String preenchaTodosCampos() {
        return "Preencha Todos os Campos";
    }
}
