package TP.cs.cs04.view;

import TP.cs.cs04.model.pilha.*;

public class TestEx1 {
    public static void main(String[] args) {
        Pilha<Integer> stack1 = new PilhaSequencial<>();
        Pilha<Integer> stack2 = new PilhaEncadeada<>();

        for (int i = 1; i <= 5; i++) {
            stack1.push(i);
            stack2.push(i);
        }

        System.out.println("\nComparando as duas pilhas: " + compareToStack(stack1, stack2));
        System.out.println(stack1);
        System.out.println(stack2);
        
        stack1.push(6);
        System.out.println("\nModificando a pilha 1 e comparando novamente: " + compareToStack(stack1, stack2));
        System.out.println(stack1);
        System.out.println(stack2);
    }

    private static <T> int compareToStack(Pilha<T> stack1, Pilha<T> stack2) {
        if(stack1.size() == stack2.size()) {
            if(stack1.isEmpty() && stack2.isEmpty()) {
                return 1;
            }

            Pilha<T> temp1 = new PilhaEncadeada<>();
            Pilha<T> temp2 = new PilhaEncadeada<>();

            temp1.push(stack1.pop());
            temp2.push(stack2.pop());

            while (stack1.top() != null && stack2.top() != null) {
                if (!stack1.top().equals(stack2.top())) {
                    return 0;
                }
                temp1.push(stack1.pop());
                temp2.push(stack2.pop());
            }

            while (temp1.top() != null) {
                stack1.push(temp1.pop());
                stack2.push(temp2.pop());
            }
            
            return 1;
        }
        return 0;
    }
}
