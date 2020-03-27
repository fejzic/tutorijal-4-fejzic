package ba.unsa.etf.rs.tut3;
import java.util.ArrayList;

public class Racun {
    static class StavkaRacuna{
        private Artikal artikal;
        private int kolicina;

        public StavkaRacuna(Artikal artikal, int kolicina) {

            this.artikal = artikal;
            this.kolicina = kolicina;
        }



        public Artikal getArtikal() {
            return artikal;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public int getKolicina() {
            return kolicina;
        }

        public void setKolicina(int kolicina) {
            this.kolicina = kolicina;
        }
    }



    private ArrayList<StavkaRacuna>stavkeRacuna ;

    public Racun() {
        stavkeRacuna = new ArrayList<>();

    }

    public void dodajStavku(Artikal artikal, int i) {
        stavkeRacuna.add(new StavkaRacuna(artikal, i));
    }

    public double ukupanIznos() {
        double suma=0;
        for (StavkaRacuna stavkaRacuna : stavkeRacuna) {
            suma += stavkaRacuna.getKolicina() * stavkaRacuna.artikal.getCijena();

        }
        return suma;
    }
    @Override
    public String toString() {
        String output = "";
        for (StavkaRacuna stavkaRacuna : stavkeRacuna) {
            output += stavkaRacuna.getArtikal().getSifra() + " " + " " + stavkaRacuna.getKolicina() + " " + stavkaRacuna.getArtikal().getCijena() * stavkaRacuna.getKolicina() + "\n";
        }
        output += "Ukupan iznos:  " + ukupanIznos();
        return output.toString();
    }
}
