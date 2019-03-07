package com.calc;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarTime {
    ArrayList<Time> times;
    public static void main(String[] args) {
        GerenciarTime gt = new GerenciarTime();
        gt.times = new ArrayList<>();
        int opMenuPrincipal = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("1 - Cadastrar Time\n2 - Listar times\n3 - Cadastrar Jogadores em um time\n4 - Listar Jogadores de um time\nOpcão: ");
            opMenuPrincipal = Integer.parseInt(sc.nextLine());

            switch (opMenuPrincipal){
                case 1:
                        gt.cadastrarTime();
                    break;
                case 2:
                        System.out.println(gt.listarTimes());
                    break;
                case 3:
                        if(gt.times.size() == 0){
                            System.out.println("Não Há times cadastrados");
                        }else{
                            System.out.print("Digite o indice do time que deseja inserir jogadores: ");
                            gt.cadastrarJogadoresDeUmTime(Integer.parseInt(sc.nextLine()));
                        }
                    break;
                case 4:
                        if(gt.times.size() == 0){
                            System.out.println("Não Há times cadastrados");
                        }else{
                            System.out.print("Digite o indice do time que deseja listar jogadores: ");
                            gt.listarJogadoresDeUmTime(Integer.parseInt(sc.nextLine()));
                        }

                    break;
            }//switch

        }while (opMenuPrincipal != 9);
    }//main


    private void cadastrarTime(){
        Scanner sc = new Scanner(System.in);
        Time time = new Time();
        System.out.print("Digite o ID do time: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Digite o nome do time: ");
        String nome = sc.nextLine();

        System.out.println("Deseja cadastrar os jogadores agora? [1 = SIM; 2 = NÃO]");
        int resposta = Integer.parseInt(sc.nextLine());
        ArrayList<Jogador> jogadores;
        if(resposta == 1){
            jogadores = cadastrarJogadoresDeUmTime(time.getJogadores());
            time.cadastrarTime(id, nome, jogadores);
            times.add(time);
            System.out.println("Time cadastrado com jogadores");
        }else{
            System.out.println("Time cadastrado sem jogadores");
            time.cadastrarTime(id, nome, new ArrayList());
            times.add(time);
        }
    }//cadastrarTime

    private String listarTimes(){
        String retorno = "";
        if (times.size() == 0)
            retorno = "Não Há times cadastrados";
        else
            for (Time t: times) retorno += "\n " + t.getNome()+" \n";
        return retorno;
    }//ListarTimes

    private void cadastrarJogadoresDeUmTime(int index){
        Time time = times.get(index);
        if(time != null){
            ArrayList<Jogador> jogadores = cadastrarJogadoresDeUmTime(time.getJogadores());
            time.setJogadores(jogadores);
            System.out.println("jogadores do time cadastrado com sucesso");
        }else{
            System.out.println("Time inexistente");

        }
    }//cadastrarJogadoresDeUmTime

    private ArrayList<Jogador> cadastrarJogadoresDeUmTime(ArrayList<Jogador> jogadores){
        Scanner sc = new Scanner(System.in);
        ArrayList<Jogador> retornoJogadores = new ArrayList<>(jogadores);
        int op=1;
        do {

           switch (op){
               case 1:
                       Jogador jogador = new Jogador();
                       System.out.print("Digite o nome do jogador: ");
                       jogador.setNome(sc.nextLine());

                       System.out.print("Digite o numero do jogador: ");
                       jogador.setNumero(Integer.parseInt(sc.nextLine()));

                       System.out.print("Digite a idade do jogador: ");
                       jogador.setIdade(Integer.parseInt(sc.nextLine()));

                       System.out.print("Digite a posicao do jogador: ");
                       jogador.setPosicao(sc.nextLine());
                       retornoJogadores.add(jogador);
                   break;
               case 2:
                   System.out.println("Fim de inserção de jogadores");
                   break;
               default:
                   System.out.println("Opção invalida");
            }//switch

            System.out.print("Quer adicionar mais um jogador? [1 = SIM; 2 = NÃO]");
            op = Integer.parseInt(sc.nextLine());
        }while(op != 2);
        return retornoJogadores;
    }//cadastrarJogadoresDeUmTime

    private void listarJogadoresDeUmTime(int index){
        Time time = times.get(index);
        if(time != null){
            System.out.println(time.listarJogadores());
        }else{
            System.out.println("Time inexistente");
        }
    }//cadastrarJogadoresDeUmTime

}//GerenciarTime
