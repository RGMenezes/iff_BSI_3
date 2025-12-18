package TP.cs.cs05.view;

import java.util.Arrays;

import TP.cs.cs05.model.RecursiveFunctions;

public class TestEx1 {
    public static void main(String[] args) {
        int[] testArrayFull = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] testArrayEmpty = new int[10];

        int[] testArrayIncomplete = new int[10];
        testArrayIncomplete[0] = 1;
        testArrayIncomplete[1] = -2;
        testArrayIncomplete[2] = 3;
        testArrayIncomplete[3] = 5;
        testArrayIncomplete[4] = -1;
        testArrayIncomplete[5] = 0;

        System.out.println("<<< Teste da função que soma um vetor de inteiros >>>");

        System.out.println("\nVetor Cheio: " + Arrays.toString(testArrayFull));
        System.out.println("Soma: " + RecursiveFunctions.sumIntArray(testArrayFull));

        System.out.println("\nVetor Vazio: " + Arrays.toString(testArrayEmpty));
        System.out.println("Soma: " + RecursiveFunctions.sumIntArray(testArrayEmpty));

        System.out.println("\nVetor Incompleto: " + Arrays.toString(testArrayIncomplete));
        System.out.println("Soma: " + RecursiveFunctions.sumIntArray(testArrayIncomplete));
    }
}
