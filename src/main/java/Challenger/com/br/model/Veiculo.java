package Challenger.com.br.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {
    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("imagemUrl")
    private String imagemUrl;

    public String getModelo() {
        return modelo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
