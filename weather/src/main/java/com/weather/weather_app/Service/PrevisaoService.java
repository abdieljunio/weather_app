package com.weather.weather_app.Service;

import com.weather.weather_app.Model.Clima;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class PrevisaoService {

    private final WebClient webClient;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    public PrevisaoService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(apiUrl).build();
    }

    public Clima obterClimaPorCidade(String cidade) {
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("key", apiKey)
                            .queryParam("q", cidade)
                            .build())
                    .retrieve()
                    .bodyToMono(Clima.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Erro ao obter dados: " + e.getMessage());
        }
    }
}
