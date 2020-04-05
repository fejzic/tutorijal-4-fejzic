package ba.unsa.etf.rs.tut3;

import java.util.ArrayList;
import java.util.HashSet;

public class Artikal {
        private String sifra;
        private String naziv;
        private double cijena;

    public Artikal(String abc, String proizvod, double v) {
    }


    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if (sifra.isEmpty())throw new IllegalArgumentException("Sifra je prazan");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty())throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena < 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }



    public Artikal (String inParameters) {
        //String[] artikal =  inParameters.split(",");
        //this.sifra=artikal[0];
        int i = 0;
        for (String parameter: inParameters.split(",")) {
            if (i == 0) {
                if (parameter.isEmpty()) {
                    throw new IllegalArgumentException("Šifra je prazna");
                }
                this.sifra = parameter;
                i++;
            }
            else if (i == 1) {
                if (parameter.isEmpty()) {
                    throw new IllegalArgumentException("Naziv je prazan");
                }
                this.naziv = parameter;
                i++;
            }
            else {
                if (Double.parseDouble(parameter.trim()) <= 0 ) {
                    throw new IllegalArgumentException("Cijena je negativna");
                }
                i = 0;
                this.cijena = Double.parseDouble(parameter.trim());
            }
        }
    }

    public Artikal() {
    }

    @Override
    public String toString() {
        String parametri = null;
        parametri += this.sifra;
        parametri += ",";
        parametri += this.naziv;
        parametri += ",";
        parametri += cijena;
        return parametri;
    }



    Object o = new Object();
    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikal){
        for(int i = 0; i < artikal.size();i++)
            for(int j = i+1; j < artikal.size();j++)
                if (artikal.get(i).equals(artikal.get(j))){
                    artikal.remove(j);
                    j--;
                }

        return artikal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikal artikal = (Artikal) o;
        return Double.compare(artikal.cijena, cijena) == 0 &&
                sifra.equals(artikal.sifra) &&
                naziv.equals(artikal.naziv);
    }




}

