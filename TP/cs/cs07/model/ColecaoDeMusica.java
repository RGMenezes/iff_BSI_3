package TP.cs.cs07.model;

public interface ColecaoDeMusica {
    void adicionarMusica(Musica musica);
    void excluirMusica(String nomeDaMusica);
    Musica obterMusica(int posicaoDaMusica);
    int obterTotalDeMusicas();
    void trocarPosicaoEntreMusicas(int pos1, int pos2);
    void alterarMusica(int posicao, Musica novaMusica);
}
