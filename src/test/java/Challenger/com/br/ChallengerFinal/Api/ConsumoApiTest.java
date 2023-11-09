package Challenger.com.br.ChallengerFinal.Api;

import Challenger.com.br.Api.ConsumoApi;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsumoApiTest {

    @Test
    public void testObterDados() {
        ConsumoApi consumoApi = new ConsumoApi();
        String dados = consumoApi.obterDados("URL_DA_API_AQUI");

        assertNotNull(dados);

    }
}

