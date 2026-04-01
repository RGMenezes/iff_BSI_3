package TP.cs.cs08.model;

public class ListaDeMusica implements ColecaoDeMusica {
    private No inicio;
    private Iterador iterador;
    private int totalDeMusicas;

    public ListaDeMusica() {
        this.inicio = null;
        this.iterador = new Iterador(inicio, 0);
        this.totalDeMusicas = 0;
    }

    @Override
    public void adicionarMusica(Musica musica) throws IllegalArgumentException {
        No novoNo = new No(musica);
        if (inicio == null) {
            iterador.setNo(novoNo);
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
        totalDeMusicas++;    
    }

    @Override
    public void excluirMusica(String nomeDaMusica) throws IllegalArgumentException {
        if (inicio == null) {
            throw new IllegalArgumentException("Não há músicas para excluir.");
        }

        if (inicio.getMusica().getTitulo().equals(nomeDaMusica)) {
            inicio = inicio.getProx();
            totalDeMusicas--;

            if(iterador.getPosicao() == 0) {
                iterador.setIterador(inicio, 0);
            }else if(iterador.getPosicao() > 0) {
                iterador.setPosicao(iterador.getPosicao() - 1);
            }

            return;
        }

        No atual = inicio;
        int posicao = 0;
        while (atual.getProx() != null) {
            if (atual.getProx().getMusica().getTitulo().equals(nomeDaMusica)) {
                atual.setProx(atual.getProx().getProx());
                totalDeMusicas--;
                if(iterador.getPosicao() > posicao) {
                    iterador.setPosicao(iterador.getPosicao() - 1);
                }
                return;
            }
            atual = atual.getProx();
            posicao++;
        }
        

        throw new IllegalArgumentException("Música não encontrada: " + nomeDaMusica);
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (inicio == null) {
            throw new IllegalArgumentException("Não há músicas na coleção.");
        }

        if (posicaoDaMusica < 0 || posicaoDaMusica >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicaoDaMusica);
        }

        No atual = null;

        if(iterador.getPosicao() <= posicaoDaMusica) {
            atual = iterador.getNo();
            for (int i = iterador.getPosicao(); i < posicaoDaMusica; i++) {
                atual = atual.getProx();
            }
            iterador.setIterador(atual, posicaoDaMusica);
        }else{
            atual = inicio;
            for (int i = 0; i < posicaoDaMusica; i++) {
                atual = atual.getProx();
            }
        }
        return atual.getMusica();
    }

    @Override
    public int obterTotalDeMusicas() {
        return totalDeMusicas;
    }

    @Override
    public void trocarPosicaoEntreMusicas(int pos1, int pos2) throws IllegalArgumentException, IndexOutOfBoundsException {

        if (totalDeMusicas < 2) {
            throw new IllegalArgumentException("É necessário ter pelo menos 2 músicas para trocar posições.");
        }

        if (pos1 < 0 || pos1 >= totalDeMusicas || pos2 < 0 || pos2 >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posições inválidas: " + pos1 + ", " + pos2);
        }

        if (pos1 == pos2) {
            return;
        }

        No no1 = null, no2 = null, atual = inicio;
        for (int i = 0; i <= Math.max(pos1, pos2); i++) {
            if (i == pos1) {
                no1 = atual;
            }
            if (i == pos2) {
                no2 = atual;
            }
            atual = atual.getProx();
        }

        Musica temp = no1.getMusica();
        no1.setMusica(no2.getMusica());
        no2.setMusica(temp);
    }

    @Override
    public void alterarMusica(int posicao, Musica novaMusica) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (inicio == null) {
            throw new IllegalArgumentException("Não há músicas para alterar.");
        }

        if (posicao < 0 || posicao >= totalDeMusicas) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }

        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProx();
        }
        atual.setMusica(novaMusica);
    }

    @Override
    public void ordenarMusicas(Ordenador ordenador) throws IllegalArgumentException {
        if (totalDeMusicas < 2) {
            throw new IllegalArgumentException("É necessário ter pelo menos 2 músicas para ordenar.");
        }

        ordenador.ordenar(this);
    }
}

class No {
    private Musica musica;
    private No prox;

    public No(Musica musica) {
        this.musica = musica;
        this.prox = null;
    }

    public Musica getMusica() {
        return musica;
    }
    public void setMusica(Musica musica) {
        this.musica = musica;
    }
    public No getProx() {
        return prox;
    }
    public void setProx(No prox) {
        this.prox = prox;
    }
}

class Iterador {
    private No no;
    private int posicao;

    public Iterador(No inicio, int posicao) {
        this.no = inicio;
        this.posicao = posicao;
    }

    public void setIterador(No no, int posicao) {
        this.no = no;
        this.posicao = posicao;
    }

    public No getNo() {
        return no;
    }
    public void setNo(No no) {
        this.no = no;
    }

    public int getPosicao() {
        return posicao;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}