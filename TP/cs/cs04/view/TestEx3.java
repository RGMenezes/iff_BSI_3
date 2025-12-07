package TP.cs.cs04.view;

import TP.cs.cs04.model.pilha.*;

public class TestEx3 {
    public static void main(String[] args) {
        String expr1 = "(a + b) * (c + d)";
        String expr2 = "((a + b) * (c + d)";
        String expr3 = "(a + b)) + (c + d(";

        System.out.println("\nExpressão: " + expr1 + " está correta? " + correctParentheses(expr1));
        System.out.println("Expressão: " + expr2 + " está correta? " + correctParentheses(expr2));
        System.out.println("Expressão: " + expr3 + " está correta? " + correctParentheses(expr3));
    }

    private static boolean correctParentheses(String expr) {
        Pilha<Character> openParentheses = new PilhaSequencial<>();
        Pilha<Character> closeParentheses = new PilhaSequencial<>();

        for (char c : expr.toCharArray()) {
            if (c == '(') {
                openParentheses.push(c);
            } else if (c == ')') {
                closeParentheses.push(c);
            }
        }

        return openParentheses.size() == closeParentheses.size();
    }
}
