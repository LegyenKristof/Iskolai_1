package hu.petrik.javafilmdb;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
            hibaKiir(e);
        }
    }

    private void hibaKiir(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(e.getClass().toString());
        alert.setContentText(e.getMessage());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> alert.show());
            }
        }, 500);
    }

    @FXML
    public void torles(ActionEvent actionEvent) {
    }

    @FXML
    public void hozzaadas(ActionEvent actionEvent) {
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(FilmApp.class.getResource("hozzaad-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 150);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void modositas(ActionEvent actionEvent) {
    }
}