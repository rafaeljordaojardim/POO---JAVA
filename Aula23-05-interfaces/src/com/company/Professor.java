package com.company;

import java.time.LocalDateTime;

public class Professor extends Funcionario implements Entravel{
    @Override
    public void entrarFatec() {
        System.out.println("Professor entrou na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
    }

    @Override
    public void sairFatec() {
        System.out.println("Professor saiu na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
        GerenciarAcesso ga = new GerenciarAcesso();
        ga.remove(this);

    }
}
