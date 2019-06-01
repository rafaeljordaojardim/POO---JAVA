package com.company;

import java.time.LocalDateTime;

public class Aluno implements Entravel
{
    @Override
    public void entrarFatec() {
        System.out.println("Aluno entrou na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
    }

    @Override
    public void sairFatec() {
        System.out.println("Aluno saiu na fatec em ");
        LocalDateTime dataAgora = LocalDateTime.now();
        System.out.println(dataAgora);
    }
}
