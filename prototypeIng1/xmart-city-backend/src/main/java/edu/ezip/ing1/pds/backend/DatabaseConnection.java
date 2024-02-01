package edu.ezip.ing1.pds.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/ezip-ing1";
        String username = "postgres";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connexion réussie !");
            
            String query = "SELECT * FROM \"ezip-ing1\".students ORDER BY id ASC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String firstname = resultSet.getString("firstname");
                String group = resultSet.getString("group");

                System.out.println("ID: " + id + ", Nom: " + name + ", Prénom: " + firstname + ", Groupe: " + group);
            }

            resultSet.close();
            statement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
