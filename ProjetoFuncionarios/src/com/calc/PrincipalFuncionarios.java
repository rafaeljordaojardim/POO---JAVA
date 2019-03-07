package com.calc;

import java.util.Scanner;

public class PrincipalFuncionarios {
    public final int T = 10;
    public static int indice = 0;
    Funcionario[] func = new Funcionario[T];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrincipalFuncionarios pf = new PrincipalFuncionarios();
        int op = 0;
        while(op != 9){
            System.out.printf("1-Cadastrar\n2-Consultar\n3-Bonificar\n9-Sair\nOpcao:");
            op = Integer.parseInt(in.nextLine());
            switch (op){
                case 1:
                        pf.execCadastro();
                    break;
                case 2:
                        pf.execConsulta();
                    break;
                case 3:
                        pf.execBonificacao();
                    break;
                default:
                    System.out.println("opcao invalida");
            }//switch
        }//while
    }//main

    public void execCadastro(){
        Scanner in = new Scanner(System.in);
        func[indice] = new Funcionario();
        System.out.print("Digite o nome: ");
        func[indice].setNome(in.nextLine());

        System.out.print("Digite o departamento: ");
        func[indice].setDepartamento(in.nextLine());

        System.out.print("Digite o salario: ");
        func[indice].setSalario(Double.parseDouble(in.nextLine()));

        System.out.print("Digite o RG: ");
        func[indice].setRG(in.nextLine());

        System.out.print("Ele esta na empresa? S/N: ");
        String resp = in.nextLine();
        if (resp.equalsIgnoreCase("S"))
            func[indice].setEstaNaEmpresa(true);
        else
            func[indice].setEstaNaEmpresa(false);
        System.out.println("\n"+func[indice].getNome()+"\n Cadastrado com Sucesso!\n");
        indice++;
        if (indice >=T){
            indice = 0;
            System.out.println("indice maior que "+ T+", a variavel foi reinicializada com 0");
        }

    }//execCadastro

    public void execBonificacao(){
        Scanner in = new Scanner(System.in);
        if(indice == 0)
            System.out.println("Cadastre pelo menos um funcionario");
        else{
            System.out.println("Digite o indice do funcionario que quer bonificar");
            int posicao = Integer.parseInt(in.nextLine());
            if(posicao < 0 || posicao > 9) {
                System.out.println("Posicao invalida! 0 - 9");
                return;
            }
            if(posicao > indice){
                System.out.println("Não há funcionario criado nesta posicao");
            }else{
                System.out.println("Qual o valor da bonificacao? ");
                double valor = Double.parseDouble(in.nextLine());
                func[posicao].bonificar(valor);
                System.out.println("Aumento concedito");
            }//else
        }//else
    }//execBonificacao

    public void execConsulta() {
        Scanner in = new Scanner(System.in);
        if (indice == 0)
            System.out.println("Cadastre pelo menos um funcionario");
        else {
            System.out.print("Digite o indice do funcionario que quer Consultar : ");
            int posicao = Integer.parseInt(in.nextLine());
            if (posicao < 0 || posicao > 9) {
                System.out.println("Posicao invalida! 0 - 9");
                return;
            }
            if (posicao > indice) {
                System.out.println("Não há funcionario criado nesta posicao");
            } else {
                System.out.println(func[posicao].toString());
            }//else
        }//else
    }//execConsulta
}//PrincipalFuncionarios
