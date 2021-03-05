package pkg_24_01_tennivalo;

import java.time.LocalDate;

public class Tennivalo {

    private String nev;
    private int fontossag;
    private LocalDate hatarido;
    private boolean elvegzett;
    private static int ID = 1;
    private int sorszam;

    public Tennivalo(String nev, int fontossag, LocalDate hatarido) {
        this.nev = nev;
        this.fontossag = fontossag;
        this.hatarido = hatarido;
        this.sorszam = ID;
        ID++;
    }

    public int getSorszam() {
        return this.sorszam;
    }

    public void setSorszam(int sorszam) {
        this.sorszam = sorszam;
        ID++;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setFontossag(int fontossag) {
        this.fontossag = fontossag;
    }

    public int getFontossag() {
        return fontossag;
    }

    public void setHatarido(LocalDate hatarido) {
        this.hatarido = hatarido;
    }

    public LocalDate getHatarido() {
        return hatarido;
    }

    public void setElvegzett(boolean elvegzett) {
        this.elvegzett = elvegzett;
    }

    public boolean isElvegzett() {
        return elvegzett;
    }

}
