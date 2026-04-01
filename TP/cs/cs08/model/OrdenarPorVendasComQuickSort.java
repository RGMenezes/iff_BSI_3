package TP.cs.cs08.model;

public class OrdenarPorVendasComQuickSort implements Ordenador {
    public OrdenarPorVendasComQuickSort() {}

    @Override
    public void ordenar(ColecaoDeMusica colecao) throws IllegalArgumentException {
        quickSort(colecao, 0, colecao.obterTotalDeMusicas() - 1);
    }

    private void quickSort(ColecaoDeMusica colecao, int inicio, int fim) {
        if (inicio < fim) {
            int pi = particao(colecao, inicio, fim);

            quickSort(colecao, inicio, pi - 1);
            quickSort(colecao, pi + 1, fim);
        }
    }

    private int particao(ColecaoDeMusica colecao, int inicio, int fim) {
        double pivo = colecao.obterMusica(fim).getVendas();
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (colecao.obterMusica(j).getVendas() < pivo) {
                i++;
                colecao.trocarPosicaoEntreMusicas(i, j);
            }
        }
        colecao.trocarPosicaoEntreMusicas(i + 1, fim);
        return i + 1;
    }
}
