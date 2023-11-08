package Challenger.com.br.menu;

import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.service.ClienteDAO;

import java.util.Scanner;

public class CadastroCliente {
    public static void realizarCadastro(Scanner scanner) {
        System.out.println("Cadastro Cliente");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o carro: ");
        String carro = scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Peso do veículo: ");
        String pesoVeiculo = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Senha:  ");
        String senha = scanner.nextLine();

        ConnectionManager connectionManager = new ConnectionManager();

        Cliente novoCliente = new Cliente(nome, carro, placa, pesoVeiculo, cpf , senha);

        if (ClienteDAO.inserirNoBancoDeDados(novoCliente, connectionManager)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o cadastro.");
        }
    }
}



