package Challenger.com.br.Controler;

import Challenger.com.br.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccess {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String DB_USER = "seu_usuario";
    private static final String DB_PASSWORD = "";

    public Cliente obterInformacoesDoCliente(String cpf) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT nome, carro, placa, peso_veiculo, cpf, senha FROM clientes WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String carro = resultSet.getString("carro");
                String placa = resultSet.getString("placa");
                String pesoVeiculo = resultSet.getString("peso_veiculo");
                String senha = resultSet.getString("senha");


                Cliente cliente = new Cliente(nome, carro, placa, pesoVeiculo, cpf, senha);

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
