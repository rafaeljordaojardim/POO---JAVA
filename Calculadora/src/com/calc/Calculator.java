package com.calc;

public class Calculator {

    public static double doSoma(double n1, double n2){
        double resultado = 0.0;
        resultado = n1 + n2;
        return resultado;
    }//doSoma

    public static double doSub(double n1, double n2){
        double resultado = 0.0;
        resultado = n1 - n2;
        return resultado;
    }//doSoma

    public static double doDiv(double n1, double n2){
        double resultado = 0.0;
        if(n1 != 0 && n2 != 0)
            resultado = n1 / n2;
        return resultado;
    }//doSoma

    public static double doMult(double n1, double n2){
        double resultado = 0.0;
            resultado = n1 * n2;
        return resultado;
    }//doSoma
}
