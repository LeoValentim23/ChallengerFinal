package Challenger.com.br.menu;

import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.service.VerificadorCadastro;
import Challenger.com.br.service.ClienteService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo ao Menu Principal!");

        VerificadorCadastro verificadorCadastro = new VerificadorCadastro(new ConnectionManager());

        while (true) {
            System.out.println("Selecione a opção:");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro Cliente");
            System.out.println("3 - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        if (Login.realizarLogin(scanner, verificadorCadastro)) {

                        }
                        break;
                    case 2:
                        CadastroCliente.realizarCadastro(scanner);
                        break;
                    case 3:
                        System.out.println("Obrigado por utilizar o sistema!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        }
    }
}
