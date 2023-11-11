package Challenger.com.br.Controler;

import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccess {
    private final ConnectionManager connectionManager;

    public DatabaseAccess(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Cliente obterInformacoesDoCliente(String cpf) {
        Cliente cliente = null;

        try (Connection connection = connectionManager.getConnection()) {
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

                cliente = new Cliente(nome, carro, placa, pesoVeiculo, cpf, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}

