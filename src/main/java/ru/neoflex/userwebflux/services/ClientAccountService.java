package ru.neoflex.userwebflux.services;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.models.client.Client;

public interface ClientAccountService {
    Mono<Client> create(ClientDto clientDto, String source);

    Mono<ClientDto> findById(String id);

    Flux<ClientDto> search(SearchFilter filters);
}
