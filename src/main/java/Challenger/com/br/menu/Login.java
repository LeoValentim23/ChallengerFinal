package Challenger.com.br.menu;

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

        // Verifica o cadastro usando o VerificadorCadastro
        if (verificadorCadastro.verificarCadastro(cpf, senha)) {
            // O usuário está cadastrado
            System.out.println("Login bem-sucedido. Bem-vindo!");

            String placa = ClienteService.obterPlacaDoCliente(cpf);
            String carro = ClienteService.obterCarroDoCliente(cpf);
            MenuVeiculo.mostrarMenu(scanner, placa, carro);

            return true;
        } else {
            // O usuário não está cadastrado
            System.out.println("Login falhou. CPF ou senha incorretos.");
            return false;
        }
    }
}

