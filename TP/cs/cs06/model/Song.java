package TP.cs.cs06.model;

import java.util.Arrays;

public class Song {
    private String title;
    private String artist;
    private int year;
    private int sales;
    private int streams;
    private int downloads;
    private int radioPlays;
    private double rating;
    private boolean fullData;

    public Song(String title, String artist, int year, int sales, int streams, int downloads, int radioPlays, double rating, boolean fullData) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;
        this.streams = streams;
        this.downloads = downloads;
        this.radioPlays = radioPlays;
        this.rating = rating;
        this.fullData = fullData;
    }

    public Song(String csvLine) {
        if (csvLine == null || csvLine.isBlank()) {
            throw new IllegalArgumentException("Linha CSV vazia ou nula.");
        }

        String[] parts = splitCsvLine(csvLine);

        this.artist = parts[0].trim();
        this.title = parts[1].trim();

        try {
            this.year = Integer.parseInt(parts[2].trim());
            this.sales = Integer.parseInt(parts[3].trim());
            this.streams = Integer.parseInt(parts[4].trim());
            this.downloads = Integer.parseInt(parts[5].trim());
            this.radioPlays = Integer.parseInt(parts[6].trim());
            this.rating = Double.parseDouble(parts[7].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número inválido na linha CSV.", e);
        }

        if(this.artist != null && !this.artist.isEmpty() && this.title != null && !this.title.isEmpty() 
            && this.year > 0 && this.sales > 0 && this.streams > 0 && this.rating > 0
        ) {
            this.fullData = true;
        }
    }

    public String[] splitCsvLine(String csvLine) {
        char[] charsLine = csvLine.toCharArray();
        int partsCount = 0;
        String[] parts = new String[8];
        Arrays.fill(parts, "");

        for (int i = 0; i < charsLine.length; i++) {
            if (charsLine[i] == ',' && i > 0 && charsLine[i - 1] == '"') {
                partsCount++;
                if (partsCount > 7) {
                    throw new IllegalArgumentException("Linha CSV inválida: " + csvLine);
                }
            } else {
                if(charsLine[i] != '"') {
                    if(partsCount > 1 && partsCount < 7) {
                        if(charsLine[i] != '.'){
                            parts[partsCount] += charsLine[i];
                        }
                    }else{
                        parts[partsCount] += charsLine[i];
                    }
                }
            }
        }

        if (partsCount != 7) {
            throw new IllegalArgumentException("Linha CSV inválida: " + csvLine);
        }

        return parts;
    }

    public String toString() {
        return "Song {" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", sales=" + sales +
                ", streams=" + streams +
                ", downloads=" + downloads +
                ", radioPlays=" + radioPlays +
                ", rating=" + rating +
                ", fullData=" + fullData +
                '}';
    }


    // Getters e setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getRadioPlays() {
        return radioPlays;
    }

    public void setRadioPlays(int radioPlays) {
        this.radioPlays = radioPlays;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFullData() {
        return fullData;
    }

    public void setFullData(boolean fullData) {
        this.fullData = fullData;
    }

}
