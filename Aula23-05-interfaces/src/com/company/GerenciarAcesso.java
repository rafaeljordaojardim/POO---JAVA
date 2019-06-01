package com.company;

import java.util.ArrayList;
import java.util.List;

public class GerenciarAcesso {

    private static List<Entravel> entraveis = new ArrayList<>();
    public static List<Entravel> getTotalPessoas(){
        return entraveis;
    }

    public  void add(Entravel entravel){
        entraveis.add(entravel);
    }

    public  void remove(Entravel entravel){
        entraveis.remove(entravel);
    }
}
