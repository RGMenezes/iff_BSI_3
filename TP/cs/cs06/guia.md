## Lista de Exercicios - Tecnicas de Programacao

**Professor:** Fabio Duncan

**Data:** Marco 2026

**Secao:** Manipulacao de arquivos e filtragem de dados

---

### I. Exercicio de Leitura e Escrita de Arquivos CSV

#### 1. Filtragem de Registros do Dataset Song.csv

**Objetivo:** Fazer um programa para ler os registros do `Song.csv` e criar um novo arquivo onde deverao ser armazenados os registros que obedecerem ao criterio de filtragem a seguir:

- Somente os campos `Artist`, `Title`, `Year`, `Sales`, `Streams` e `Rating` deverao ser armazenados no arquivo de destino.
- Somente deverao ser armazenados no arquivo os registros cujos 6 campos citados possuam conteudo. Caso um unico campo esteja vazio, ou tenha valor `0`, o registro nao devera ser copiado.

##### Algoritmo

O programa devera fazer a leitura de um registro do dataset, filtrar o registro e, caso seja um registro candidato a ser armazenado, armazena-lo no arquivo de destino. Estes passos deverao se repetir ate que o final do arquivo `Song.csv` seja atingido.

##### Observacoes

- Utilizar o tratamento de excecoes na implementacao com arquivos.
- O arquivo gerado devera ser guardado para ser utilizado em exercicios futuros.

Dataset disponivel em:

`https://www.kaggle.com/datasets/shiivvvaam/top-songs-of-the-world`
