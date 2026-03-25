package TP.cs.cs07.model;

import java.util.Arrays;

public class VetorDeMusica implements ColecaoDeMusica{
    private Musica[] musicas;
    private int totalDeMusicas;

    public VetorDeMusica(int capacidade) {
        this.musicas = new Musica[capacidade];
        this.totalDeMusicas = 0;
    }

    @Override
    public void adicionarMusica(Musica musica) {
        if (totalDeMusicas >= musicas.length) {
            musicas = Arrays.copyOf(musicas, musicas.length * 2);
        }
        musicas[totalDeMusicas++] = musica;
    }

    @Override
    public void excluirMusica(String nomeDaMusica) {
        if (totalDeMusicas == 0) {
            throw new IllegalArgumentException("Não há músicas para excluir.");
        }

        boolean encontrou = false;

        for (int i = 0; i < totalDeMusicas; i++) {

            if (musicas[i].getTitulo().equals(nomeDaMusica)) {
                System.arraycopy(musicas, i + 1, musicas, i, totalDeMusicas - i - 1);
                musicas[--totalDeMusicas] = null;
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new IllegalArgumentException("Música não encontrada: " + nomeDaMusica);
        }
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {
        if(totalDeMusicas == 0) {
            throw new IllegalArgumentException("Não há músicas na coleção.");
        }
        
        if (posicaoDaMusica < 0 || posicaoDaMusica >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicaoDaMusica);
        }
        return musicas[posicaoDaMusica];
    }

    @Override
    public int obterTotalDeMusicas() {
        return totalDeMusicas;
    }

    @Override
    public void trocarPosicaoEntreMusicas(int pos1, int pos2) {
        if (totalDeMusicas < 2) {
            throw new IllegalArgumentException("É necessário ter pelo menos 2 músicas para trocar posições.");
        }
        if (pos1 < 0 || pos1 >= totalDeMusicas || pos2 < 0 || pos2 >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posições inválidas: " + pos1 + ", " + pos2);
        }
        Musica temp = musicas[pos1];
        musicas[pos1] = musicas[pos2];
        musicas[pos2] = temp;
    }

    @Override
    public void alterarMusica(int posicao, Musica novaMusica) {
        if (totalDeMusicas == 0) {
            throw new IllegalArgumentException("Não há músicas para alterar.");
        }
        if (posicao < 0 || posicao >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        musicas[posicao] = novaMusica;
    }
}
