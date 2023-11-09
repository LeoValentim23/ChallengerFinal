package Challenger.com.br.ChallengerFinal.Api;

import Challenger.com.br.Api.VeiculoAPI;
import org.junit.Test;
import static org.junit.Assert.*;

public class VeiculoAPITest {

    @Test
    public void testObterImagemPorModelo() {
        VeiculoAPI veiculoAPI = new VeiculoAPI();
        String imagemUrl = veiculoAPI.obterImagemPorModelo("Idea Advent./ Adv.LOCKER 1.8 mpi Flex 5p");

        assertNotNull(imagemUrl);

    }
}

