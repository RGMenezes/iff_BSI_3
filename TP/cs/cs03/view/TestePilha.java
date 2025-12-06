import TP.cs.cs03.model.pilha.*;

public class TestePilha {
    public static void main(String[] args) {
        System.out.println("Teste Pilha");

        // Criação da pilha
        Pilha<Integer> pilha = new PilhaEncadeada<>();
        // Pilha<Integer> pilha = new PilhaSequencial<>();
        System.out.println("\nPilha criada: " + pilha);

        // Teste de push
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("\nApós pushes: " + pilha);

        // Teste de top
        System.out.println("\nTopo da pilha: " + pilha.top());

        // Teste de pop
        System.out.println("\nPop: " + pilha.pop());
        System.out.println("Após pop: " + pilha);

        // Verificação se a pilha está vazia
        System.out.println("\nPilha vazia? " + pilha.isEmpty());

        // Pop restante
        pilha.pop();
        pilha.pop();
        System.out.println("\nApós pops restantes: " + pilha);
        System.out.println("Pilha vazia? " + pilha.isEmpty());
    }
}
