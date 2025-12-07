package TP.cs.cs04.view;

import TP.cs.cs04.model.pilha.*;

public class TestEx6 {
    public static void main(String[] args) {
        String expr1 = "3 4 + 2 * 7 /";
        String expr2 = "5 1 2 + 4 * + 3 -";
        String expr3 = "10 2 8 * + 3 -";

        // expr1 = ((3 + 4) * 2) / 7 = 2
        // expr2 = 5 + ((1 + 2) * 4) - 3 = 14
        // expr3 = (10 + (2 * 8)) - 3 = 23

        System.out.println("\nExpressão: " + expr1 + " = " + calculator(expr1));
        System.out.println("Expressão: " + expr2 + " = " + calculator(expr2));
        System.out.println("Expressão: " + expr3 + " = " + calculator(expr3));
    }

    private static Integer calculator(String expr) {
        for (Character c : expr.toCharArray()) {
            if("0123456789+-/* ".indexOf(c) == -1) {
                throw new IllegalArgumentException("Caracter inválido na expressão: " + c);
            }
        }

        Pilha<Integer> stack = new PilhaEncadeada<>();

        for (String token : expr.split(" ")) {

            if ("+-/*".indexOf(token) == -1) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = 0;

                switch (token) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                }
                stack.push(result);
            }
        }
        if(!(stack.size() == 1)) {
            throw new IllegalStateException("Expressão inválida: pilha não contém exatamente um elemento após o cálculo.");
        }
        return stack.pop();
    }
}
