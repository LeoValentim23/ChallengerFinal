package Challenger.com.br.Api;

import Challenger.com.br.model.Veiculo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VeiculoAPI {

    private static final String API_URL = "https://gist.githubusercontent.com/adrianlemess/b0563f69103d899d0cabe3b331161d19/raw/28043174c30fa8aaf82449bda24e5f9799c0489a/dbpath.json";

    public static String obterImagemPorModelo(String modelo) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.body());

                for (JsonNode veiculoNode : rootNode.get("veiculos")) {
                    Veiculo veiculo = objectMapper.treeToValue(veiculoNode, Veiculo.class);

                    if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                        return veiculo.getImagemUrl();
                    }
                }
            } else {
                System.out.println("Erro ao obter a resposta da API: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao obter a resposta da API: " + e.getMessage());
        }

        return null;
    }
}
