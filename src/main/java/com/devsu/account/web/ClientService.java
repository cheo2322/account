package com.devsu.account.web;

import com.devsu.account.handler.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ClientService {

  private final WebClient webClient;

  public ClientService() {
    this.webClient = WebClient.builder().baseUrl("http://person:8080").build();
  }

  public Mono<Void> checkClientExistence(String clientIdentification) {
    return webClient
        .get()
        .uri("/test/v1/clients/".concat(clientIdentification))
        .exchangeToMono(
            clientResponse -> {
              if (clientResponse.statusCode().is2xxSuccessful()) {
                return Mono.empty();
              } else {
                return Mono.error(new EntityNotFoundException("Client not found."));
              }
            });
  }
}
