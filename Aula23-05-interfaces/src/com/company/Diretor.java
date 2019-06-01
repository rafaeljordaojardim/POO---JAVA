package com.company;

import java.time.LocalDateTime;

public class Diretor extends Funcionario implements Entravel{

    @Override
    public void entrarFatec() {
        GerenciarAcesso ga = new GerenciarAcesso();
        System.out.println("Diretor entrou na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
        ga.add(this);

    }

    @Override
    public void sairFatec() {
        GerenciarAcesso ga = new GerenciarAcesso();
        System.out.println("Diretor saiu na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
        ga.remove(this);
    }
}
