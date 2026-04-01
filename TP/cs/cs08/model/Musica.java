package TP.cs.cs08.model;

import java.util.Arrays;

public class Musica {
    private String artista;
    private String titulo;
    private int ano;
    private int vendas;
    private int streams;
    private double avaliacao;

    public Musica(String artista, String titulo, int ano, int vendas, int streams, double avaliacao) {
        this.artista = artista;
        this.titulo = titulo;
        this.ano = ano;
        this.vendas = vendas;
        this.streams = streams;
        this.avaliacao = avaliacao;
    }

    public Musica(String linhaDataset) throws IllegalArgumentException, NumberFormatException {
        String[] partes = separarCampos(linhaDataset);

        this.artista = partes[0];
        this.titulo = partes[1];
        this.ano = Integer.parseInt(partes[2]);
        this.vendas = Integer.parseInt(partes[3]);
        this.streams = Integer.parseInt(partes[4]);
        this.avaliacao = Double.parseDouble(partes[5]);
    }

    private String[] separarCampos(String linhaDataset) throws IllegalArgumentException {
        char[] caracteres = linhaDataset.toCharArray();
        String[] campos = new String[6];
        int campoIndex = 0;
        boolean dentroDeAspas = false;
        Arrays.fill(campos, "");

        for (char c : caracteres) {
            if (c == '"') {
                dentroDeAspas = !dentroDeAspas;

            } else if (c == ',' && !dentroDeAspas) {
                campoIndex++;
                if (campoIndex >= campos.length) {
                    throw new IllegalArgumentException("Linha do dataset deve conter exatamente 6 campos!");
                }

            } else {
                campos[campoIndex] += c;
            }
        }

        if (campoIndex != campos.length - 1) {
            throw new IllegalArgumentException("Linha do dataset deve conter exatamente 6 campos!");
        }

        return campos;
    }

    @Override
    public String toString() {
        return String.format("{ Artista: %s, Título: %s, Ano: %d, Vendas: %d, Streams: %d, Avaliação: %.3f }",
                artista, titulo, ano, vendas, streams, avaliacao);
    }

    public String toString(
        boolean mostrarArtista, 
        boolean mostrarTitulo, 
        boolean mostrarAno, 
        boolean mostrarVendas, 
        boolean mostrarStreams, 
        boolean mostrarAvaliacao
    ) {
        StringBuilder sb = new StringBuilder("{ ");
        if (mostrarArtista) sb.append("Artista: ").append(artista).append(", ");
        if (mostrarTitulo) sb.append("Título: ").append(titulo).append(", ");
        if (mostrarAno) sb.append("Ano: ").append(ano).append(", ");
        if (mostrarVendas) sb.append("Vendas: ").append(vendas).append(", ");
        if (mostrarStreams) sb.append("Streams: ").append(streams).append(", ");
        if (mostrarAvaliacao) sb.append("Avaliação: ").append(String.format("%.3f", avaliacao)).append(" ");
        sb.append("}");
        return sb.toString();
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}