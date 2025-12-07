package TP.cs.cs04.view;

import TP.cs.cs04.model.fila.Fila;
import TP.cs.cs04.model.fila.FilaEncadeada;

public class TestEx4 {
    public static void main(String[] args) {
        Fila<Integer> queue = new FilaEncadeada<>();
        Fila<Integer> oddQueue = new FilaEncadeada<>();
        Fila<Integer> evenQueue = new FilaEncadeada<>();

        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        System.out.println("\nFila original: " + queue);
        filterOddAndEven(queue, oddQueue, evenQueue);

        System.out.println("\nFila de números ímpares: " + oddQueue);
        System.out.println("Fila de números pares: " + evenQueue);
    }

    private static void filterOddAndEven(Fila<Integer> queue, Fila<Integer> oddQueue, Fila<Integer> evenQueue) {
        while (!queue.isEmpty()) {
            Integer element = queue.dequeue();
            if (element.intValue() % 2 == 0) {
                evenQueue.enqueue(element);
            } else {
                oddQueue.enqueue(element);
            }
        }
    }
}
