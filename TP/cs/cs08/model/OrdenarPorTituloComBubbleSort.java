package TP.cs.cs08.model;

public class OrdenarPorTituloComBubbleSort implements Ordenador {
    public OrdenarPorTituloComBubbleSort() {}

    @Override
    public void ordenar(ColecaoDeMusica colecao) throws IllegalArgumentException {
        int n = colecao.obterTotalDeMusicas();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String titulo1 = colecao.obterMusica(j).getTitulo().toLowerCase();
                String titulo2 = colecao.obterMusica(j + 1).getTitulo().toLowerCase();
                if (titulo1.compareTo(titulo2) > 0) {
                    colecao.trocarPosicaoEntreMusicas(j, j + 1);
                }
            }
        }
    }
}
