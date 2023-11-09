package Challenger.com.br.ChallengerFinal.service;

import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.model.Cliente;
import Challenger.com.br.service.ClienteDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteDAOTest {

    private ConnectionManager connectionManager;
    private ClienteDAO clienteDAO;

    @BeforeEach
    public void setUp() {

        connectionManager = new ConnectionManager();  // Substitua pela sua implementação real
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void testInserirNoBancoDeDados() throws SQLException {

        Cliente cliente = new Cliente("NomeTeste", "CarroTeste", "PlacaTeste", "PesoTeste", "CpfTeste", "SenhaTeste");


        boolean insercaoSucesso = clienteDAO.inserirNoBancoDeDados(cliente, connectionManager);


        assertTrue(insercaoSucesso, "A inserção no banco de dados deve ser bem-sucedida.");
    }
}
