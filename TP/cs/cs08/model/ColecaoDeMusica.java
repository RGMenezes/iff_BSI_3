package TP.cs.cs08.model;

public interface ColecaoDeMusica {
    void adicionarMusica(Musica musica) throws IllegalArgumentException;
    void excluirMusica(String nomeDaMusica) throws IllegalArgumentException;
    Musica obterMusica(int posicaoDaMusica) throws IllegalArgumentException, IndexOutOfBoundsException;
    int obterTotalDeMusicas();
    void trocarPosicaoEntreMusicas(int pos1, int pos2) throws IllegalArgumentException, IndexOutOfBoundsException;
    void alterarMusica(int posicao, Musica novaMusica) throws IllegalArgumentException, IndexOutOfBoundsException;
    void ordenarMusicas(Ordenador ordenador) throws IllegalArgumentException;
}
