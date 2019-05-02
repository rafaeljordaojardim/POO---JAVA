package com.company;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GerenciarControlePonto {

    public static void main(String[] args) throws InterruptedException {
	    Gerente gerente = new Gerente();
	    gerente.setNome("Carlos");
	    gerente.setDocumento("34324324");
	    RegistroPonto rg = new RegistroPonto();
	    rg.setFunc(gerente);
	    rg.setDataRegistro(LocalDate.of(2019,05,01));
	    rg.setHoraEntrada(8,00);
	    rg.setHoraSaida(17, 30);

        System.out.println(rg.apresentarRegistroPonto());

		Thread.sleep(4000);


		Gerente gerente1 = new Gerente();
		gerente1.setNome("Rafael");
		gerente1.setDocumento("34324324");
		RegistroPonto rg1 = new RegistroPonto();
		rg1.setFunc(gerente);
		rg1.setDataRegistro(LocalDate.of(2019,05,01));
		rg1.setHoraEntrada(8,00);
		rg1.setHoraSaida(17, 30);

		System.out.println(rg1.apresentarRegistroPonto());
    }
}
