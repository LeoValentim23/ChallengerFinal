import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteController {
    private final ConnectionManager connectionManager;

    public ClienteController(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void inserirClienteEmTabelas(Cliente cliente) {
        String querySegurado = "INSERT INTO tb_segurado (NOME_SEGURADO, CPF_SEGURADO, SENHA_SEGURADO) VALUES (?, ?, ?)";
        String queryApoliceVeiculo = "INSERT INTO tb_apolice_veiculo (Placa_veiculo) VALUES (?)";
        String queryVeiculo = "INSERT INTO tb_veiculo (PESO_VEICULO) VALUES (?)";
        String queryMarca = "INSERT INTO tb_marca (tb_marca) VALUES (?)";

        try (Connection dbConnection = connectionManager.getConnection();
             PreparedStatement preparedStatementSegurado = dbConnection.prepareStatement(querySegurado);
             PreparedStatement preparedStatementApoliceVeiculo = dbConnection.prepareStatement(queryApoliceVeiculo);
             PreparedStatement preparedStatementVeiculo = dbConnection.prepareStatement(queryVeiculo);
             PreparedStatement preparedStatementMarca = dbConnection.prepareStatement(queryMarca)) {

            // Dados para tb_segurado
            preparedStatementSegurado.setString(1, cliente.getNome());
            preparedStatementSegurado.setString(2, cliente.getCpf());
            preparedStatementSegurado.setString(3, cliente.getSenha());
            preparedStatementSegurado.executeUpdate();

            // Dados para tb_apolice_veiculo
            preparedStatementApoliceVeiculo.setString(1, cliente.getPlaca());
            preparedStatementApoliceVeiculo.executeUpdate();

            // Dados para tb_veiculo
            preparedStatementVeiculo.setString(1, cliente.getPesoVeiculo());
            preparedStatementVeiculo.executeUpdate();

            // Dados para tb_marca
            preparedStatementMarca.setString(1, cliente.getNome());
            preparedStatementMarca.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
