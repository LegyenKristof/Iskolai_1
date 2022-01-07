package hu.petrik.javafilmdb;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class HozzaadController {
    @javafx.fxml.FXML
    private TextField inKategoria;
    @javafx.fxml.FXML
    private Spinner<Integer> inHossz;
    @javafx.fxml.FXML
    private TextField inCim;
    @javafx.fxml.FXML
    private ChoiceBox<Integer> inErtekeles;

    @javafx.fxml.FXML
    public void hozzaad(ActionEvent actionEvent) {
        String cim = inCim.getText().trim();
        String kategoria = inKategoria.getText().trim();
        int hossz = inHossz.getValue();
        int ertekeles = inErtekeles.getValue();
    }
}
