## Lista de Exercícios - Aplicando pilhas e filas

* **Professor:** Fábio Duncan 
* **Data:** 06/12/2025
* **Seção 1:** Aplicação de pilhas e filas

---

### I. Exercícios com Pilhas (Stack)

Aqui estão os exercícios focados no uso do Tipo Abstrato de Dados (TAD) **Pilha**, que opera sob o princípio **LIFO** (*Last-In, First-Out*).

#### 1. Comparação de Pilhas
* **Objetivo:** Desenvolver uma função para **comparar** se duas pilhas (`pilha1` e `pilha2`) são **iguais**.
* **Critério de Igualdade:** Devem possuir os **mesmos elementos** na **mesma ordem**.
* **Retorno:**
    * `1` se `pilha1 = pilha2`.
    * `0` se `pilha1 \neq pilha2`.
* **Requisito:** Utilizar o TAD Pilha desenvolvido anteriormente.
* **Teste:** Implementar um programa principal para testar a funcionalidade.

#### 2. Inversão de String
* **Objetivo:** Criar uma função para **inverter a ordem dos caracteres** de uma string.
* **Requisito Obrigatório:** Utilizar uma **Pilha** como memória temporária.
* **Modificação do TAD:** O TAD Pilha deve ser **alterado** para operar com o tipo **`char`**.
* **Teste:** O programa principal deve ler uma frase de até **20 caracteres**, realizar a inversão e imprimir o resultado.

#### 3. Validação de Parênteses em Expressões
* **Objetivo:** Implementar uma função que utilize a estrutura **Pilha** para verificar se o **número de abre parênteses** (`(`) é igual ao **número de fecha parênteses** (`)`) em uma expressão matemática.
* **Requisito:** Utilizar o TAD Pilha desenvolvido na questão anterior (adaptado para `char`).
* **Lógica Simplificada:** A função deve apenas contar a igualdade, e não a correta aninhamento (embora a estrutura Pilha seja ideal para verificar o aninhamento também, este exercício foca apenas na contagem).

---

### II. Exercícios com Filas (Queue)

Os exercícios a seguir exploram o uso do Tipo Abstrato de Dados (TAD) **Fila**, que opera sob o princípio **FIFO** (*First-In, First-Out*).

#### 4. Separação de Elementos Pares e Ímpares
* **Objetivo:** Implementar uma função para **separar** os elementos de uma fila.
* **Entradas/Saídas:** A função recebe três filas já inicializadas:
    * `filaOriginal` (com valores).
    * `filaImpares` (vazia).
    * `filaPares` (vazia).
* **Processo:** Os valores da `filaOriginal` devem ser distribuídos:
    * Valores **pares** $\rightarrow$ `filaPares`.
    * Valores **ímpares** $\rightarrow$ `filaImpares`.
* **Estado Final:** Após a execução, a `filaOriginal` deve estar **vazia**.
* **Teste:** Imprimir os valores presentes em cada fila no programa principal.

#### 5. Inversão de Fila Usando Pilha
* **Objetivo:** Escrever uma função para **inverter a ordem dos elementos** de uma fila (`F`).
* **Estruturas Auxiliares:** Utilizar apenas uma pilha vazia (`P`).
* **Operações Permitidas:** Apenas testes de fila/pilha vazias, `Enfileira`, `Desenfileira`, `Empilha` e `Desempilha`.
* **Lógica:** O processo deve envolver:
    1.  Transferir todos os elementos da Fila (`F`) para a Pilha (`P`).
    2.  Transferir todos os elementos da Pilha (`P`) de volta para a Fila (`F`).

---

### III. Exercício de Aplicação Integrada (Pilha)

#### 6. Calculadora com Notação Polonesa Reversa (RPN)
* **Objetivo:** Implementar um programa que funcione como uma **calculadora** utilizando a **Notação Polonesa Reversa (RPN)**.
* **Requisito do TAD:** Utilizar o **TAD Pilha** desenvolvido para armazenar e manipular os operandos.

##### Regras e Funcionalidades:

* **Entrada:** O programa deve ler a expressão RPN em **uma única linha**, com cada elemento (número ou operador) **separado por espaços**.
* **Operandos:** Números reais (`double`).
* **Operadores Permitidos:** `+`, `-`, `*`, `/`.

##### Processamento:

* **Ao encontrar um número (operando):** Deve-se **Empilhar** o valor.
* **A cada operador encontrado:**
    1.  **Retirar** os **dois últimos operandos** da pilha (o segundo operando é o primeiro a ser retirado/desempilhado, e o primeiro operando é o último a ser retirado).
    2.  **Realizar** a operação correspondente.
    3.  **Empilhar** o resultado de volta.
* **Resultado Final:** Ao final da leitura da expressão, a pilha deve conter **apenas um valor**, que é o resultado final da expressão.