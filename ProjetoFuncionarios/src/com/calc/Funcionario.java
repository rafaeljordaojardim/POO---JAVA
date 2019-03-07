package com.calc;

public class Funcionario {
    //ATRIBUTOS
    private String nome;
    private String departamento;
    private double salario;
    private String RG;
    private boolean estNaEmpresa;

    //ACESSORES
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public boolean isEstaNaEmpresa() {
        return estNaEmpresa;
    }

    public void setEstaNaEmpresa(boolean estNaEmpresa) {
        this.estNaEmpresa = estNaEmpresa;
    }

    //CONSTRUTORES
    public Funcionario(String nome, String departamento, double salario, String RG, boolean estNaEmpresa) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
        this.RG = RG;
        this.estNaEmpresa = estNaEmpresa;
    }
    public Funcionario() {
        this.nome = "";
        this.departamento = "";
        this.salario = 0.0;
        this.RG = "";
        this.estNaEmpresa = true;
    }
    public Funcionario(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.departamento = funcionario.getDepartamento();
        this.salario = funcionario.getSalario();
        this.RG = funcionario.getRG();
        this.estNaEmpresa = funcionario.isEstaNaEmpresa();
    }

    //METODOS
    public void bonificar(double aumento){
        if (aumento>0)
            this.setSalario(this.getSalario() + aumento);
    }//bonificar

    //COMPLEMENTARES
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                ", RG='" + RG + '\'' +
                ", estNaEmpresa=" + estNaEmpresa +
                '}';
    }
}//Funcionario
