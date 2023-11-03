package ru.neoflex.userwebflux.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.models.client.Client;
import ru.neoflex.userwebflux.services.ClientAccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Validated
public class ClientAccountController implements ClientAccountAPI {
    private final ClientAccountService clientAccountService;

    @Override
    public Mono<Client> create(@Valid ClientDto clientDto, String source) {
        return clientAccountService.create(clientDto, source);
    }

    @Override
    public Mono<ClientDto> findById(String id) {
        return clientAccountService.findById(id);
    }

    @Override
    public Flux<ClientDto> search(SearchFilter filters) {
        return clientAccountService.search(filters);
    }
}
