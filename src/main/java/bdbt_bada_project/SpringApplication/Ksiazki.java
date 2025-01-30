package bdbt_bada_project.SpringApplication;

public class Ksiazki {
    private int id_ksiazki;
    private String tytul;
    private String isbn;
    private int id_biblioteki;
    private int id_wydawnictwa;

    public Ksiazki(int id_ksiazki, String tytul, String isbn, int id_biblioteki, int id_wydawnictwa) {
        super();
        this.id_ksiazki = id_ksiazki;
        this.tytul = tytul;
        this.isbn = isbn;
        this.id_biblioteki = id_biblioteki;
        this.id_wydawnictwa = id_wydawnictwa;
    }

    @Override
    public String toString() {
        return "Ksiazki{" +
                "id_ksiazki=" + id_ksiazki +
                ", tytul='" + tytul + '\'' +
                ", isbn='" + isbn + '\'' +
                ", id_biblioteki=" + id_biblioteki +
                ", id_wydawnictwa=" + id_wydawnictwa +
                '}';
    }

    public int getId_ksiazki() {
        return id_ksiazki;
    }

    public String getTytul() {
        return tytul;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getId_biblioteki() {
        return id_biblioteki;
    }

    public int getId_wydawnictwa() {
        return id_wydawnictwa;
    }

    public void setId_ksiazki(int id_ksiazki) {
        this.id_ksiazki = id_ksiazki;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId_biblioteki(int id_biblioteki) {
        this.id_biblioteki = id_biblioteki;
    }

    public void setId_wydawnictwa(int id_wydawnictwa) {
        this.id_wydawnictwa = id_wydawnictwa;
    }
}
