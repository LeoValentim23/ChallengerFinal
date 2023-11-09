
package Challenger.com.br.ChallengerFinal;

import Challenger.com.br.menu.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengerFinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengerFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu.mostrarMenuPrincipal();
	}
}
