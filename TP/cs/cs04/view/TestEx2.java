package TP.cs.cs04.view;

import java.util.Scanner;

import TP.cs.cs04.model.pilha.*;

public class TestEx2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        System.out.print("\nDigite uma string para ser invertida (máximo 20 caracteres): ");
        String userInput = input.nextLine();

        System.out.println("\nString invertida: " + reverseString(userInput));

    }

    private static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        if(charArray.length <= 20) {
            Pilha<Character> stack = new PilhaSequencial<>();
            for (char c : charArray) {
                stack.push(c);
            }

            String reversedStr = "";
            while (!stack.isEmpty()) {
                reversedStr += stack.pop();
            }

            return reversedStr;
        }
        return "Sua string é muito grande!";
    }
}
