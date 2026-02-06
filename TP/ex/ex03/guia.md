# Lista de Exercícios - Técnicas de Programação

**Professor:** Fábio Duncan  
**Data:** Agosto 2025  
**Assunto:** Ordenação e Busca

---

## Exercícios de Fixação

1. **Teste de Eficiência** Fazer um programa para testar a eficiência dos algoritmos de ordenação apresentados em aula. Os algoritmos deverão ser testados com massas de dados de **100.000**, **500.000** e **1.000.000** de números inteiros aleatórios.  
   * O seu programa deverá obter o **tempo de execução** de cada algoritmo para cada uma das massas de dados.

2. **Algoritmo Híbrido (Quicksort + Insertion Sort)** Implemente uma estratégia de ordenação que utilize os algoritmos **Quicksort** e **Insertion Sort**. A ordenação deverá funcionar normalmente até que uma partição fique com uma quantidade de elementos menor ou igual a **16**.  
   * As partições que forem atingindo este tamanho vão sendo ordenadas utilizando o algoritmo Insertion Sort.  
   * Faça o teste para **1.000.000** de números inteiros e compare o tempo computacional com o tempo do Quicksort tradicional para o mesmo volume de dados.

3. **Busca Sequencial vs. Binária** Crie um programa para ordenar, com o algoritmo mais eficiente, uma massa de dados de **1.000.000** de números inteiros aleatórios.  
   * Teste o tempo de execução dos algoritmos de **busca sequencial** e **busca binária** para 5 valores distintos.  
   * Some os tempos computacionais de cada valor buscado para fins de comparação.
