package TP.cs.cs05.view;

import java.util.Arrays;

import TP.cs.cs05.model.RecursiveFunctions;

public class TestEx3 {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayB = {1, -2, 6, 1, 23, -6, 12, -1, -12, -1, -1, 2};
        int[] arrayC = {-100, -12, -1243, -12, -345, -45, -68};
        int[] arrayD = {1};
        int[] arrayE = {};

        System.out.println("<<< Teste da função que encontra o maior valor >>>");

        System.out.println("\nVetor A: " + Arrays.toString(arrayA));
        System.out.println("Maior elemento: " + RecursiveFunctions.findLargestElement(arrayA));

        System.out.println("\nVetor B: " + Arrays.toString(arrayB));
        System.out.println("Maior elemento: " + RecursiveFunctions.findLargestElement(arrayB));
        
        System.out.println("\nVetor C: " + Arrays.toString(arrayC));
        System.out.println("Maior elemento: " + RecursiveFunctions.findLargestElement(arrayC));

        System.out.println("\nVetor D: " + Arrays.toString(arrayD));
        System.out.println("Maior elemento: " + RecursiveFunctions.findLargestElement(arrayD));

        System.out.println("\nVetor E: " + Arrays.toString(arrayE));
        System.out.println("Maior elemento: " + RecursiveFunctions.findLargestElement(arrayE));
    }
}
