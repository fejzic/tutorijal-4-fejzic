package ba.unsa.etf.rs.tut3;
import java.util.ArrayList;
import java.util.List;

public class Racun {

    public Artikal getArtikal;
    private Artikal artikal;
    private int kolicina;

    public Racun() {

    }

    public Artikal getArtikal() {
        return artikal;
    }

    private void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public int getKolicina() {
        return kolicina;
    }

    private void setKolicina(int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException("Kolicina je premala");
        }
        this.kolicina = kolicina;
    }



    private List<Racun> stavke = new ArrayList<Racun> ();

    public List getStavke() {
        return stavke;
    }


    //konstruktor
    public Racun (Artikal artikal, int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException("Kolicina je premala");
        }
        this.artikal = artikal;
        this.kolicina = kolicina;
    }

    private ArrayList<Artikal> racun = new ArrayList<>();
    public void dodajStavku(Artikal artikal, int kolicina) {
        artikal.setSifra(artikal.getSifra());
        artikal.setNaziv(artikal.getNaziv());
        artikal.setCijena(artikal.getCijena());
        if(kolicina < 0) throw new IllegalArgumentException("Količina ne može biti negativna!");

        for(int i=0;i<kolicina;i++) this.racun.add(artikal);
    }

    public double ukupanIznos() {
        double suma=0;
        for (Artikal artikal : this.racun) suma += artikal.getCijena();
        return suma;
    }

}

