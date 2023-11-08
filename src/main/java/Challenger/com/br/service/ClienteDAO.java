package Challenger.com.br.service;



import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public static boolean inserirNoBancoDeDados(Cliente cliente, ConnectionManager connectionManager) {
        try (Connection dbConnection = connectionManager.getConnection()) {
            String query = "INSERT INTO clientes (nome, carro, placa, peso_veiculo, cpf ,senha) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setString(2, cliente.getCarro());
                preparedStatement.setString(3, cliente.getPlaca());
                preparedStatement.setString(4, cliente.getPesoVeiculo());
                preparedStatement.setString(5, cliente.getCpf());
                preparedStatement.setString(6, cliente.getSenha());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

