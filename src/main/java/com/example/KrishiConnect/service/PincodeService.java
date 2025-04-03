package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.PincodeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PincodeService {
    private final WebClient webClient;

    public PincodeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://www.postalpincode.in/api/pincode").build();
    }
    public Mono<PincodeResponse> getPincodeDetails(String pincode) {
        return webClient.get()
                .uri("/{pincode}", pincode)
                .retrieve()
                .bodyToMono(PincodeResponse.class);
    }
}
