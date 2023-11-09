package Challenger.com.br.service;

import Challenger.com.br.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteService {
    private ConnectionManager connectionManager;

    public ClienteService(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public String obterPlacaDoCliente(String cpf) {
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT placa FROM clientes WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("placa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String obterCarroDoCliente(String cpf) {
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT carro FROM clientes WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("carro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}



