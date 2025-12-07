package TP.cs.cs04.view;

import TP.cs.cs04.model.pilha.*;
import TP.cs.cs04.model.fila.*;

public class TestEx5 {
    public static void main(String[] args) {
        Fila<Integer> queue = new FilaEncadeada<>();

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        System.out.println("\nFila original: " + queue);
        invertQueue(queue);
        System.out.println("Fila invertida: " + queue);
    }

    private static <T> void invertQueue(Fila<T> queue) {
        Pilha<T> stack = new PilhaEncadeada<>();

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        
    }
}
