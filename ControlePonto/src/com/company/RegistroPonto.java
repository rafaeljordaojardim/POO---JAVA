package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RegistroPonto {
    private long idRegPonto;
    private Funcionario func;
    private LocalDate dataRegistro;
    private LocalTime horaEntrada;
    private  LocalTime horaSaida;

    public long getIdRegPonto() {
        return idRegPonto;
    }

    public void setIdRegPonto(long idRegPonto) {
        this.idRegPonto = idRegPonto;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int hora, int minuto) {
        this.horaEntrada = LocalTime.of(hora, minuto);;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int hora, int minuto) {
        this.horaSaida = LocalTime.of(hora, minuto);
    }


    public String apresentarRegistroPonto() {
        return "\n func=" + func.getNome() +
                "\n dataRegistro=" + dataRegistro +
                "\n horaEntrada=" + horaEntrada +
                "\n horaSaida=" + horaSaida;
    }


}
