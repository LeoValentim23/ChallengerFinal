package Challenger.com.br.menu;

import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.service.ClienteService;
import Challenger.com.br.service.VerificadorCadastro;

import java.util.Scanner;

public class Login {
    public static boolean realizarLogin(Scanner scanner, VerificadorCadastro verificadorCadastro) {
        System.out.println("Login");

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();


        if (verificadorCadastro.verificarCadastro(cpf, senha)) {

            System.out.println("Login bem-sucedido. Bem-vindo!");

            ConnectionManager connectionManager = new ConnectionManager();
            ClienteService clienteService = new ClienteService(connectionManager);
            String placa = clienteService.obterPlacaDoCliente(cpf);
            String carro = clienteService.obterCarroDoCliente(cpf);
            MenuVeiculo.mostrarMenu(scanner, placa, carro);

            return true;
        } else {

            System.out.println("Login falhou. CPF ou senha incorretos.");
            return false;
        }
    }
}





