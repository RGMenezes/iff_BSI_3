## Projeto de Programação - Técnicas de Programação

**Data:** Abril 2026

**Seção:** Padrões de Projeto e Algoritmos de Ordenação

---

### II. Implementação de Algoritmos de Ordenação e Polimorfismo

**Objetivo:** Evoluir o sistema de gerenciamento de músicas para incluir a funcionalidade de ordenação de dados, utilizando o padrão de projeto *Strategy* para permitir diferentes critérios e algoritmos de ordenação.

#### 1. Evolução da Estrutura (Diagrama de Classes)

O sistema foi expandido para suportar a ordenação polimórfica:

* **Interface `ColecaoDeMusicas`**: Recebe o novo método `ordenarMusicas(Ordenador)`. Este método deve delegar a tarefa de ordenação para o objeto ordenador recebido como parâmetro.
* **Interface `Ordenador`**: Define o contrato para os algoritmos de ordenação com o método `ordenar(ColecaoDeMusicas)`.
* **Novas Implementações de Ordenação**:
    * `OrdenarPorTituloComBubbleSort`: Implementa a ordenação alfabética por título utilizando o algoritmo Bubble Sort.
    * `OrdenarPorSalesComQuickSort`: Implementa a ordenação por volume de vendas utilizando o algoritmo Quick Sort.
* **Classe `ProgramaMusicas`**: Adiciona a funcionalidade `ordenar(ColecaoDeMusicas)` em seu escopo de execução.

#### 2. Requisitos de Implementação

Nesta etapa, o foco é a flexibilidade do código e a aplicação de algoritmos clássicos:

1.  **Interface de Ordenação**: O sistema deve ser capaz de trocar o critério de ordenação (Título ou Vendas) e o algoritmo (Bubble ou Quick) sem alterar a estrutura das classes de coleção.
2.  **Manutenção de Dados**: As funcionalidades anteriores de adição, exclusão, troca e alteração de músicas devem permanecer funcionais e integradas à nova estrutura.
3.  **Encapsulamento**: A classe `Musica` continua sendo a base de dados, exigindo que todos os campos possuam seus respectivos métodos de acesso (*getters* e *setters*) para permitir a comparação durante a ordenação.

##### Observações Adicionais

* **Interação com Dataset**: A classe `ManipulaDataset` permanece responsável pela persistência em CSV, permitindo salvar a coleção após ela ter sido devidamente ordenada.
* **Polimorfismo**: A implementação deve permitir que qualquer classe que assine a interface `ColecaoDeMusicas` (como `VetorDeMusicas` ou `ListaDeMusicas`) possa ser ordenada por qualquer implementação da interface `Ordenador`.
