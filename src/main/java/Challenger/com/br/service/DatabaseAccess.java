package Challenger.com.br.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccess {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String DB_USER = "seu_usuario";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Consulta SQL simples
            String sql = "SELECT nome, placa FROM clientes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String placa = resultSet.getString("placa");
                System.out.println("Nome: " + nome + ", Placa: " + placa);
            }

            // Feche os recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

