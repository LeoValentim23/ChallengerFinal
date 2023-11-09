package Challenger.com.br.ChallengerFinal.Menu;

import Challenger.com.br.menu.MenuVeiculo;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MenuVeiculoTest {

    @Test
    public void testMostrarMenu() {

        String input = "sim\n"; // Simula a resposta "sim" do usuário.
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        Scanner scanner = new Scanner(System.in);


        MenuVeiculo.mostrarMenu(scanner, "qwe0987", "Idea Advent./ Adv.LOCKER 1.8 mpi Flex 5p");


    }
}

