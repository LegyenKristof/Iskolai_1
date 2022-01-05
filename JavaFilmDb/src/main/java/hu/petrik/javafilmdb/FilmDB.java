package hu.petrik.javafilmdb;


import java.io.LineNumberInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDB {
    Connection connection;

    public FilmDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmdb", "root", "");
    }

    public List<Film> getFilmek() throws SQLException {
        List<Film> list = new ArrayList<>();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM filmek";
        ResultSet resultSet = stmt.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int hossz = resultSet.getInt("hossz");
            int ertekeles = resultSet.getInt("ertekeles");
            String cim = resultSet.getString("cim");
            String kategoria = resultSet.getString("kategoria");
            Film film = new Film(id, hossz, ertekeles, cim, kategoria);
            list.add(film);
        }
        return list;
    }
}
