package Challenger.com.br.Api;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class ConsumoApi {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 301) {
                HttpHeaders headers = response.headers();
                String newLocation = headers.firstValue("Location").orElse(null);

                if (newLocation != null) {
                    request = HttpRequest.newBuilder()
                            .uri(URI.create(newLocation))
                            .build();

                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                }
            }

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a resposta da API: " + e.getMessage(), e);
        }
    }
}
