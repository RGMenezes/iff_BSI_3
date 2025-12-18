## 📚 Lista de Exercícios - Técnicas de Programação

**Professor:** Fábio Duncan 

**Data:** Outubro 2025 

**Seção:** Recursão 

---

### I. Exercícios de Recursão com Vetores e Strings

Esta seção foca no desenvolvimento da lógica recursiva para manipulação de estruturas de dados básicas.

#### 1. Soma de Elementos em Vetor

**Objetivo:** Desenvolver uma função recursiva que receba um vetor de números inteiros e calcule a soma de todos os seus elementos. 

**Teste:** Implementar um programa principal para validar o funcionamento da função. 


#### 2. Inversão de String

**Objetivo:** Escrever uma função recursiva que receba uma string como parâmetro e retorne uma nova string com os caracteres na ordem inversa. 

**Teste:** Implementar um programa principal para testar a inversão. 


#### 3. Busca do Maior Elemento

**Objetivo:** Encontrar o maior valor presente em um vetor utilizando recursão. 

**Parâmetros da Função:** A função deve receber o vetor e a quantidade de elementos contidos nele. 

**Retorno:** O maior valor encontrado entre os elementos do vetor. 

---

### II. Exercício de Lógica Matemática Recursiva

#### 4. Soma dos Dígitos de um Inteiro

**Objetivo:** Implementar uma função recursiva que receba um número inteiro positivo n (onde 1 < n < 9999) e retorne a soma de seus dígitos individuais. 


##### Regras e Restrições:

**Recursão Obrigatória:** A solução deve ser baseada exclusivamente em chamadas recursivas. 

**Proibições:** * Não utilizar estruturas de repetição (`for`, `while`). 
Não converter o número para string ou utilizar bibliotecas auxiliares de listas. 

**Operações Permitidas:** Utilizar apenas operações matemáticas. 


##### Dica de Implementação:

Para isolar os dígitos sem converter para texto, utilize: 

**Último dígito:** Operador de resto da divisão (`n % 10`). 

**Restante do número:** Divisão inteira (`n / 10`) para prosseguir com a próxima chamada recursiva. 


##### Exemplos de Entrada e Saída:

| Entrada | Saída |
| --- | --- |
| 5 | 5 |
| 123 | 6 |
| 4567 | 22 |
| 1001 | 2 |