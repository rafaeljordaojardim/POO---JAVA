package util;

import model.Contato;

import javax.naming.Context;
import javax.swing.*;
import java.util.List;

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

    public static String semContatos() {
        return "Sem contatos cadastrados!";
    }

    public static String adicioneContato() {
        return "Adicione um contato para cadastrar fornecedor";
    }

    public static String semFornecedores() {
        return "Sem fornecedores cadastrados!";
    }

    public static Contato pegaContatoNome(List<Contato> contatos, String nome){
        Contato retorno = null;
        for (Contato c: contatos) {
            if (c.getNome().equalsIgnoreCase(nome)){
                retorno = c;
            }
        }
        return retorno;
    }


    public static String digiteNumeroInteiro() {
        return "Digite um número inteiro";
    }
}
