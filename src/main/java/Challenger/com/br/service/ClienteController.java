package Challenger.com.br.service;

import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private VerificadorCadastro verificadorCadastro;
    private final ConnectionManager connectionManager;

    public ClienteController(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @GetMapping
    public List<Cliente> obterClientesPorCpfESenha(@RequestParam String cpf, @RequestParam String senha) {
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
                    clientes.add(new Cliente(nome, carro, placa, pesoVeiculo, cpf, senha));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}


