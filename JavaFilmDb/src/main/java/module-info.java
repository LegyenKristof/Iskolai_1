module hu.petrik.javafilmdb {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.javafilmdb to javafx.fxml;
    exports hu.petrik.javafilmdb;
}