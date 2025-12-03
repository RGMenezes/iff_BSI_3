package TP.cs.cs02.view;

import TP.cs.cs02.model.fila.*;

public class TesteFila {
    public static void main(String[] args) {
        System.out.println("Teste de Fila");

        // Criação da fila
        // Fila fila = new FilaEncadeada();
        Fila fila = new FilaSequencial();
        System.out.println("\nFila criada: " + fila);

        // Teste de enqueue
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        System.out.println("\nApós enqueues: " + fila);

        // Teste de front
        System.out.println("\nFront da fila: " + fila.front());

        // Teste de dequeue
        System.out.println("\nDequeue: " + fila.dequeue());
        System.out.println("Após dequeue: " + fila);

        // Verificação se a fila está vazia
        System.out.println("\nFila vazia? " + fila.isEmpty());

        // Dequeue restante
        fila.dequeue();
        fila.dequeue();
        System.out.println("\nApós dequeues restantes: " + fila);
        System.out.println("Fila vazia? " + fila.isEmpty());

        // Teste ponteiros desordenados front > rear (visivel apenas na fila sequencial)
        System.out.println("\n\nTeste fila, 3 posições, com ponteiros desordenados:");
        Fila filaCurta = new FilaSequencial(3);

        filaCurta.enqueue(1);
        filaCurta.enqueue(2);
        System.out.println("\nApós enqueues: ");
        System.out.println(filaCurta);

        filaCurta.dequeue();
        System.out.println("\nApós 1 dequeue: ");
        System.out.println(filaCurta);

        filaCurta.enqueue(3);
        filaCurta.enqueue(4);
        System.out.println("\nApós mais 2 enqueues, onde o elemento 4 é colocado na primeira posição do array: ");
        System.out.println(filaCurta);
    }
}
