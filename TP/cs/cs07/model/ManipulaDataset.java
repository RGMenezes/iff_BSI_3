package TP.cs.cs07.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class ManipulaDataset {
    private String caminho;
    private ColecaoDeMusica colecao;
    private static final String CABECALHO = "Artist,Title,Year,Sales,Streams,Rating";

    public ManipulaDataset(String caminho, ColecaoDeMusica colecao) {
        this.caminho = caminho;
        this.colecao = colecao;
    }

    public void ler() {
        lerNoDataset(caminho, colecao);
    }

    public void escrever() {
        escreverNoDataset(caminho, colecao);
    }

    public static void lerNoDataset(String caminho, ColecaoDeMusica colecao) {
        Path caminhoArquivo = Path.of(caminho);
        
        try (BufferedReader br = Files.newBufferedReader(caminhoArquivo)) {
            String linha = br.readLine();
            
            if (linha == null || !linha.equals(CABECALHO)) {
                throw new IllegalArgumentException("O arquivo deve conter o cabeçalho: " + CABECALHO);
            }

            while ((linha = br.readLine()) != null) {
                Musica musica = new Musica(linha);
                colecao.adicionarMusica(musica);
            }

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo: " + e.getMessage(), e);
        }
    }

    public static void escreverNoDataset(String caminho, ColecaoDeMusica colecao) {
        Path caminhoArquivo = Path.of(caminho);
        
        try (BufferedWriter bw = Files.newBufferedWriter(caminhoArquivo)) {
            bw.write(CABECALHO);
            bw.newLine();

            for (int i = 0; i < colecao.obterTotalDeMusicas(); i++) {
                Musica musica = colecao.obterMusica(i);
                String linha = String.format(Locale.US,
                    "\"%s\",\"%s\",%d,%d,%d,%.3f",
                    musica.getArtista(),
                    musica.getTitulo(),
                    musica.getAno(),
                    musica.getVendas(),
                    musica.getStreams(),
                    musica.getAvaliacao()
                );
                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever arquivo: " + e.getMessage(), e);
        }
    }
}
