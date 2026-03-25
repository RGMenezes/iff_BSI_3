## Projeto de Programação - Técnicas de Programação

**Data:** Março 2026

**Seção:** Implementação de Estruturas de Dados e Coleções

---

### I. Implementação da Primeira Parte do Projeto de Músicas

**Objetivo:** Implementar a lógica inicial para o gerenciamento de um dataset de músicas, focando na criação da interface de coleção, na classe de dados e em um menu interativo para manipulação das informações.

#### 1. Estrutura do Sistema (Diagrama de Classes)

O projeto deve seguir rigorosamente a arquitetura definida no diagrama de classes:

* **Classe `Musica`**: Entidade base que deve conter os campos do dataset, incluindo a implementação de métodos *getters* e *setters*.
* **Interface `ColecaoDeMusicas`**: Define o contrato para manipulação dos dados, contendo os métodos:
    * `adicionarMusica(Musica musica)`
    * `excluirMusica(String nomeDaMusica)`
    * `obterMusica(int posicaoDaMusica)`
    * `obterTotalDeMusicas()`
    * `trocarPosicaoEntreMusicas(int pos1, int pos2)`
    * `alterarMusica(int posicao, Musica novaMusica)`
* **Classe `ManipulaDataset`**: Responsável pela persistência e exibição, contendo métodos para listar a coleção e realizar a leitura/escrita em arquivos CSV.
* **Classe `VetorDeMusicas`**: Implementação concreta da interface utilizando arrays (vetores).

#### 2. Funcionalidades do Programa Principal

O programa (`ProgramaMusicas`) deverá apresentar um menu de opções para que o usuário interaja com o sistema e teste as seguintes funcionalidades:

1.  **Adição de música**: Inserir um novo registro na coleção.
2.  **Exclusão de música**: Remover uma música existente.
3.  **Troca de posição entre duas músicas**: Inverter a ordem de dois registros.
4.  **Alterar uma música**: Editar as informações de um registro em uma posição específica.
5.  **Finalizar o programa**: Encerrar a execução.

##### Observações Importantes

* **Escopo:** Nesta primeira etapa, **não** é necessária a implementação da classe de lista encadeada (`ListaDeMusicas`).
* **Manipulação de Arquivos:** Utilize a classe `ManipulaDataset` para integrar a leitura do arquivo CSV ao sistema.