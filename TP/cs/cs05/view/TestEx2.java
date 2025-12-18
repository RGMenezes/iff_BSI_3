package TP.cs.cs05.view;

import TP.cs.cs05.model.RecursiveFunctions;

public class TestEx2 {
    public static void main(String[] args) {
        String stringFull = "Apenas um teste";
        String stringEmpty = "";

        System.out.println("<<< Teste da função que inverte strings >>>");

        System.out.println("\nString Cheia: " + stringFull);
        System.out.println("Resultado: " + RecursiveFunctions.stringInverter(stringFull));

        System.out.println("\nString Vazia: " + stringEmpty);
        System.out.println("Resultado: " + RecursiveFunctions.stringInverter(stringEmpty));
    }
}
