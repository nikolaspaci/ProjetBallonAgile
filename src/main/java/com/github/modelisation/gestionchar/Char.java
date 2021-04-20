package com.github.modelisation.gestionchar;

public class Char {

    private String fabriquant;
    private int calibre;

    public Char(String fabriquant, int calibre) {
        this.fabriquant = fabriquant;
        this.calibre = calibre;
    }

    public String getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(String fabriquant) {
        this.fabriquant = fabriquant;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }
}
