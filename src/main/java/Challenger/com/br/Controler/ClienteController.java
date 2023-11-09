package Challenger.com.br.Controler;

import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.service.VerificadorCadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private final ConnectionManager connectionManager;
    private final VerificadorCadastro verificadorCadastro;

    public ClienteController(ConnectionManager connectionManager, VerificadorCadastro verificadorCadastro) {
        this.connectionManager = connectionManager;
        this.verificadorCadastro = verificadorCadastro;
    }

    public List<Cliente> obterClientesPorCpfESenha(String cpf, String senha) {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT nome, carro, placa, peso_veiculo, cpf, senha FROM clientes WHERE cpf = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String carro = resultSet.getString("carro");
                String placa = resultSet.getString("placa");
                String pesoVeiculo = resultSet.getString("peso_veiculo");
                String cpfFromDB = resultSet.getString("cpf");
                String senhaFromDB = resultSet.getString("senha");

                if (verificadorCadastro.verificarCadastro(cpfFromDB, senhaFromDB)) {
                    clientes.add(new Cliente(nome, carro, placa, pesoVeiculo, cpfFromDB, senhaFromDB));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
