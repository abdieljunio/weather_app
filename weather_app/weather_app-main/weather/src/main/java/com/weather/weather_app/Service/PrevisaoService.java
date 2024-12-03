package com.weather.weather_app.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weather_app.Model.Clima;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class PrevisaoService {

    private final WebClient webClient;


    public PrevisaoService() {
        String apiUrl = "https://api.weatherapi.com/v1";
        this.webClient = WebClient.create(apiUrl);
    }

    public Clima obterClimaPorCidade(String cidade) {
        System.out.println("Buscando clima para a cidade: " + cidade);
        String apiKey = "6f6841518ebc46bb9c4224023242611";
        try {
            Clima response = this.webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/current.json")
                            .queryParam("key", apiKey)
                            .queryParam("q", cidade)
                            .build())
                    .retrieve()
                    .bodyToMono(Clima.class)
                    .block();
            ObjectMapper mapper = new ObjectMapper();
            byte[] jsonResponse = mapper.writeValueAsBytes(response);
            return mapper.readValue(jsonResponse, Clima.class);
        }

        catch (Exception e) {
            System.err.println("Erro ao buscar dados da API: " + e.getMessage());
            throw new RuntimeException("Erro inesperado: " + e.getMessage());
        }
    }
}
