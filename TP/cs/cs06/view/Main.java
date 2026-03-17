package TP.cs.cs06.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Locale;

import TP.cs.cs06.model.Song;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("TP/cs/cs06/public/Song.csv");
        Path outputPath = Path.of("TP/cs/cs06/public/SongOutput.csv");

        int totalLines = 0;
        int writtenLines = 0;
        int filteredLines = 0;
        int invalidLines = 0;

        try (
            BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            BufferedWriter bw = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8);
        ) {
            bw.write("Artist,Title,Year,Sales,Streams,Rating");
            bw.newLine();

            String line = br.readLine();
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                totalLines++;

                try {
                    Song song = new Song(line);
                    if (song.isFullData()) {
                        String outputLine = String.format(
                            Locale.US,
                            "\"%s\",\"%s\",%d,%d,%d,%.3f",
                            song.getArtist(),
                            song.getTitle(),
                            song.getYear(),
                            song.getSales(),
                            song.getStreams(),
                            song.getRating()
                        );
                        bw.write(outputLine);
                        bw.newLine();
                        writtenLines++;
                    } else {
                        filteredLines++;
                    }
                } catch (IllegalArgumentException e) {
                    invalidLines++;
                    System.err.printf("Linha inválida %d: %s%n", lineNumber, e.getMessage());
                }
            }

            System.out.printf(
                "Processamento concluído. Lidas: %d, gravadas: %d, filtradas: %d, inválidas: %d%n",
                totalLines,
                writtenLines,
                filteredLines,
                invalidLines
            );
        } catch (NoSuchFileException e) {
            System.err.println("Arquivo não encontrado: " + e.getFile());
        } catch (AccessDeniedException e) {
            System.err.println("Sem permissão para acessar arquivo: " + e.getFile());
        } catch (MalformedInputException e) {
            System.err.println("Arquivo com codificação inválida. Use UTF-8.");
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
