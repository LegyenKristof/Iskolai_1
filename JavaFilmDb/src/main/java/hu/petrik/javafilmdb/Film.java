package hu.petrik.javafilmdb;

public class Film {
    private int id, hossz, ertekeles;
    private String cim, kategoria;

    public Film(int id, int hossz, int ertekeles, String cim, String kategoria) {
        this.id = id;
        this.hossz = hossz;
        this.ertekeles = ertekeles;
        this.cim = cim;
        this.kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public int getHossz() {
        return hossz;
    }

    public int getErtekeles() {
        return ertekeles;
    }

    public String getCim() {
        return cim;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public void setErtekeles(int ertekeles) {
        this.ertekeles = ertekeles;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
