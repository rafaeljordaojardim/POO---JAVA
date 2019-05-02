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
	    rg.setHoraEntrada(LocalTime.now());


        System.out.println(rg.apresentarRegistroPonto());

		Thread.sleep(2000);


		Gerente gerente1 = new Gerente();
		gerente1.setNome("Rafael");
		gerente1.setDocumento("34324324");
		RegistroPonto rg1 = new RegistroPonto();
		rg1.setFunc(gerente);
		rg1.setDataRegistro(LocalDate.now());
		rg1.setHoraEntrada(LocalTime.now());
		System.out.println(rg1.apresentarRegistroPonto());
		Thread.sleep(2000);
		rg.setHoraSaida(LocalTime.now());
		System.out.println(rg.apresentarRegistroPonto());
		Thread.sleep(2000);
		rg1.setHoraSaida(LocalTime.now());
		System.out.println(rg1.apresentarRegistroPonto());

    }
}
