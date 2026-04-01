package TP.cs.cs08.view;

import java.util.Scanner;

import TP.cs.cs08.model.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nIniciando o programa! carregando...");

            System.out.println("\nEscolha a implementação da coleção de músicas: ");
            System.out.println("1 - Vetor de música");
            System.out.println("2 - Lista de música");
            int escolha = entradaInt(scanner, "Opção: ", 1, 2);
            
            ColecaoDeMusica colecao;
            if (escolha == 1) {
                colecao = new VetorDeMusica(1000);
            } else {
                colecao = new ListaDeMusica();
            }
            
            ManipulaDataset dataset = new ManipulaDataset("TP/cs/cs08/public/Dataset.csv", colecao);
            dataset.ler();

            System.out.println("\nDados carregados com sucesso! Total de músicas: " + colecao.obterTotalDeMusicas());

            System.out.println("\n\n\n======= GERENCIADOR DE MÚSICAS =======\n");

            boolean finish = false;
            do {
                System.out.println("\nMenu (Gerenciador de músicas):");
                System.out.println("1 - Adicionar música");
                System.out.println("2 - Excluir música");
                System.out.println("3 - Trocar posição entre duas músicas");
                System.out.println("4 - Alterar música");
                System.out.println("5 - Listar músicas");
                System.out.println("6 - Ordenar");
                System.out.println("9 - Salvar");
                System.out.println("0 - Sair");

                int opcao = entradaInt(scanner, "Escolha uma opção: ", 0, 9);

                switch (opcao) {
                    case 1:
                        System.out.println("\nAdicionando nova música");
                        String artista = entradaString(scanner, "\nArtista: ", 3, 50);
                        String titulo = entradaString(scanner, "\nTítulo: ", 1, 100);
                        int ano = entradaInt(scanner, "\nAno: ", 1900, 2100);
                        int vendas = entradaInt(scanner, "\nVendas: ", 0, Integer.MAX_VALUE);
                        int streams = entradaInt(scanner, "\nStreams: ", 0, Integer.MAX_VALUE);
                        double avaliacao = entradaDouble(scanner, "\nAvaliação: ", 0.0, 5.0);

                        colecao.adicionarMusica(new Musica(artista, titulo, ano, vendas, streams, avaliacao));
                        System.out.println("Música '" + titulo + "' adicionada com sucesso!");
                        break;

                    case 2:
                        if (colecao.obterTotalDeMusicas() == 0) {
                            System.out.println("Não há músicas para excluir.");
                            break;
                        }

                        System.out.println("\nExcluindo música");
                        String tituloExcluir = entradaString(scanner, "Título da música a excluir: ", 1, 100);

                        try {
                            colecao.excluirMusica(tituloExcluir);
                            System.out.println("Música '" + tituloExcluir + "' excluída com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        if (colecao.obterTotalDeMusicas() < 2) {
                            System.out.println("É necessário ter pelo menos 2 músicas para trocar posições.");
                            break;
                        }

                        System.out.println("\nTrocando posição entre músicas");
                        int pos1 = entradaInt(scanner, "Posição da primeira música (0 a " + (colecao.obterTotalDeMusicas() - 1) + "): ",
                                0, colecao.obterTotalDeMusicas() - 1);
                        int pos2 = entradaInt(scanner, "Posição da segunda música (0 a " + (colecao.obterTotalDeMusicas() - 1) + "): ",
                                0, colecao.obterTotalDeMusicas() - 1);

                        try {
                            colecao.trocarPosicaoEntreMusicas(pos1, pos2);
                            System.out.println("Posições " + pos1 + " e " + pos2 + " trocadas com sucesso!");
                        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        if (colecao.obterTotalDeMusicas() == 0) {
                            System.out.println("Não há músicas para alterar.");
                            break;
                        }

                        System.out.println("\nAlterando música");
                        int posicao = entradaInt(scanner, "Posição da música a alterar (0 a " + (colecao.obterTotalDeMusicas() - 1) + "): ", 0, colecao.obterTotalDeMusicas() - 1);

                        String novoArtista = entradaString(scanner, "Novo artista: ", 3, 50);
                        String novoTitulo = entradaString(scanner, "Novo título: ", 1, 100);
                        int novoAno = entradaInt(scanner, "Novo ano: ", 1900, 2100);
                        int novasVendas = entradaInt(scanner, "Novas vendas: ", 0, Integer.MAX_VALUE);
                        int novosStreams = entradaInt(scanner, "Novos streams: ", 0, Integer.MAX_VALUE);
                        double novaAvaliacao = entradaDouble(scanner, "Nova avaliação (0.0 a 5.0): ", 0.0, 5.0);

                        try {
                            colecao.alterarMusica(posicao, new Musica(
                                    novoArtista, novoTitulo, novoAno, novasVendas, novosStreams, novaAvaliacao));
                            System.out.println("Música da posição " + posicao + " alterada com sucesso!");
                        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println(listarMusicas(colecao));
                        break;
                    case 6:
                        System.out.println("\nOrdenando músicas");
                        System.out.println("1 - Por título (Bubble Sort)");
                        System.out.println("2 - Por vendas (Quick Sort)");
                        int opcaoOrdenacao = entradaInt(scanner, "Escolha uma opção: ", 1, 2);
                        ordenar(colecao, opcaoOrdenacao);
                        System.out.println("Músicas ordenadas com sucesso!");
                        break;
                    case 9:
                        dataset.escrever();
                        break;
                    case 0:
                        finish = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } while (!finish);

        }catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }   
    
    private static String listarMusicas(ColecaoDeMusica colecao) {
        if (colecao.obterTotalDeMusicas() == 0) {
            return "Não há músicas cadastradas.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < colecao.obterTotalDeMusicas(); i++) {
            sb.append(colecao.obterMusica(i).toString()).append("\n");
        }
        return sb.toString();
    }

    private static void ordenar(ColecaoDeMusica colecao, int opcao){
        if (opcao == 1) {
            colecao.ordenarMusicas(new OrdenarPorTituloComBubbleSort());
        }else if (opcao == 2) {
            colecao.ordenarMusicas(new OrdenarPorVendasComQuickSort());
        }
    }

    private static int entradaInt(Scanner scanner, String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine().trim();

            try {
                int valor = Integer.parseInt(linha);
                if (valor < min || valor > max) {
                    System.out.println("Valor deve ser entre " + min + " e " + max + ". Tente novamente.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double entradaDouble(Scanner scanner, String mensagem, double min, double max) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine().trim();

            try {
                double valor = Double.parseDouble(linha);
                if (valor < min || valor > max) {
                    System.out.println("Valor deve ser entre " + min + " e " + max + ". Tente novamente.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número decimal válido.");
            }
        }
    }

    private static String entradaString(Scanner scanner, String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine().trim();

            if (valor.length() < min || valor.length() > max) {
                System.out.println("Valor deve ter entre " + min + " e " + max + " caracteres. Tente novamente.");
                continue;
            }

            return valor;
        }
    }
}


