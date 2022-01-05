package hu.petrik.javafilmdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {

    @FXML
    private TableView<Film> filmTable;
    @FXML
    private TableColumn<Film, String> colCim;
    @FXML
    private TableColumn<Film, String>  colKategoria;
    @FXML
    private TableColumn<Film, Integer>  colHossz;
    @FXML
    private TableColumn<Film, Integer>  colErtekeles;

    public void initialize(){
        colCim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        colHossz.setCellValueFactory(new PropertyValueFactory<>("hossz"));
        colErtekeles.setCellValueFactory(new PropertyValueFactory<>("ertekeles"));
        try{
            FilmDB filmDB = new FilmDB();
            List<Film> list = filmDB.getFilmek();
            for (Film film: list){
                filmTable.getItems().add(film);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void torles(ActionEvent actionEvent) {
    }

    @FXML
    public void hozzaadas(ActionEvent actionEvent) {
    }

    @FXML
    public void modositas(ActionEvent actionEvent) {
    }
}