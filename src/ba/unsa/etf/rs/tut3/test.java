package ba.unsa.etf.rs.tut3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;

public class test {
    public javafx.scene.control.TextArea inputArea;
    public javafx.scene.control.TextArea outputArea;
    @FXML
    private ChoiceBox choice;
    @FXML
    private Spinner quantity;
    @FXML
    private TextArea aktuelniRacuni;




    ArrayList<Artikal> lista = new ArrayList<Artikal>();
    Racun stavke = new Racun();



    public void initialize() {
        //definisem inkrement i dekrement spinnera koa i njegovu min i max vrijednost
        SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.quantity.setValueFactory(quantityValueFactory);



    }

    public void dodajArtikle(ActionEvent actionEvent) {
        //ArrayList<Artikal> lista = new ArrayList<Artikal>();
        String items = null;
        items = inputArea.getText();

        //uzimanje linije po linije
        for (String line: items.split("\n")) {

            //pravljenje objekta od linije preko konstruktora koji prima string
            Artikal proizvod = new Artikal(line);

            //dodavanje spomenutog objekta u listu
            lista.add(proizvod);
            //System.out.print(line);
        }

        Artikal.izbaciDuplikate(lista);
        String outputString = "";
        choice.getItems().clear();
        for (Artikal a: lista) {
            outputString += a.getSifra() + "," + a.getNaziv() + "," + a.getCijena() + "\n";
            //paralelno dovanja sifri u choice box
            choice.getItems().add(a.getSifra());
        }
        outputArea.setText(outputString);

    }

    @FXML
    private void dodajStavke(ActionEvent actionEvent) {
        String izabraniArtikl = (String) choice.getValue();
        Artikal artikalTemp = new Artikal();
        for (Artikal a: lista) {
            if (a.getSifra().equals(izabraniArtikl)) {
                artikalTemp = a;
            }
        }
        int kolicina = (int) quantity.getValue();
        stavke.dodajStavku(artikalTemp, kolicina);
        String output = "Šifra\t\t\t\tkolicina\t\t\t\tcijena\n";
        for (Object r: stavke.getStavke()) {
            Racun stavka = (Racun) r;
            output += stavka.getArtikal.getSifra() + "\t\t\t\t" + stavka.getKolicina() + "\t\t\t\t" +
                    stavka.getArtikal().getCijena() + "\n";
        }
        double total = stavke.ukupanIznos();
        output += "UKUPNO\t\t\t\t\t\t\t\t" + total;
        aktuelniRacuni.setText(output);

    }
}

