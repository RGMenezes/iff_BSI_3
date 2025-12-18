package TP.cs.cs05.view;

import TP.cs.cs05.model.RecursiveFunctions;

public class TestEx4 {
    public static void main(String[] args) {
        System.out.println("<<< Teste da função que soma elementos de um inteiro >>>");

        System.out.println("\nEntrada 5, saida esperada 5");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(5));

        System.out.println("\nEntrada 123, saida esperada 6");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(123));

        System.out.println("\nEntrada 4567, saida esperada 22");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(4567));

        System.out.println("\nEntrada 1001, saida esperada 2");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(1001));

        System.out.println("\nEntrada 123456789, saida esperada 45");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(123456789));

        System.out.println("\nEntrada -123, saida esperada 0");
        System.out.println("Saida: " + RecursiveFunctions.sumIntElements(-123));
    }
}
