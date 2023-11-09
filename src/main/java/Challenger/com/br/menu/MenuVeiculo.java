package Challenger.com.br.menu;

import Challenger.com.br.Api.VeiculoAPI;

import java.util.Scanner;

public class MenuVeiculo {
    public static void mostrarMenu(Scanner scanner, String placa, String carro) {
        System.out.println("Menu do seu veículo");
        System.out.println("Sua placa é: " + placa);
        System.out.println("Seu carro é: " + carro);


        VeiculoAPI veiculoAPI = new VeiculoAPI();


        String imagemUrl = veiculoAPI.obterImagemPorModelo(carro);

        if (imagemUrl != null) {
            System.out.println("Imagem do seu veículo: " + imagemUrl);

        } else {
            System.out.println("Imagem do veículo não encontrada.");
        }

        System.out.println("Quer realizar alguma ação (Digite 'sim' ou 'nao')?");
        String resposta = scanner.nextLine();

        if ("sim".equalsIgnoreCase(resposta)) {
            System.out.println("Redirecionar para a funcionalidade de chamado");
            Chamado.realizarChamado(scanner);
        }
    }
}

