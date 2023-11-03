package ru.neoflex.userwebflux.services;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.models.client.Client;

public interface ClientService {
    Mono<Client> save(Client client);

    Mono<Client> findById(String id);

    Flux<Client> search(SearchFilter filters);
}
