package Challenger.com.br.service;

import Challenger.com.br.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificadorCadastro {
    private final ConnectionManager connectionManager;

    public VerificadorCadastro(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public boolean verificarCadastro(String cpf, String senha) {
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT cpf, senha FROM clientes WHERE cpf = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
