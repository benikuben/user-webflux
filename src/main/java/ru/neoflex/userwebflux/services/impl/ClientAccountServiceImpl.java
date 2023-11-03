package ru.neoflex.userwebflux.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.exceptions.NotFoundException;
import ru.neoflex.userwebflux.models.client.Client;
import ru.neoflex.userwebflux.services.ClientAccountService;
import ru.neoflex.userwebflux.services.ClientService;
import ru.neoflex.userwebflux.services.ValidationService;
import ru.neoflex.userwebflux.services.ValidationSourceService;
import ru.neoflex.userwebflux.util.mappers.ClientMapper;

@Service
@RequiredArgsConstructor
@Validated
@Slf4j
public class ClientAccountServiceImpl implements ClientAccountService {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final ValidationService validationService;
    private final ValidationSourceService validationSourceService;

    @Override
    public Mono<Client> create(ClientDto clientDto, String sourceName) {
        log.info("Client to save {}", clientDto);
        log.info("Source {}", sourceName);

        return validationSourceService.findByName(sourceName)
                .switchIfEmpty(Mono.error(new NotFoundException("Validation source not found")))
                .flatMap(source -> Mono.just(source.getRules())
                        .switchIfEmpty(Mono.error(new NotFoundException("Validation rules not found")))
                        .map(rules -> {
                            validationService.validateRequiredParameters(rules, clientDto);
                            return source;
                        }))
                .then(
                        clientService.save(clientMapper.clientDtoToClient(clientDto))
                )
                .log();
    }

    @Override
    public Mono<ClientDto> findById(String id) {
        log.info("Find client by id {}", id);

        return clientService.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Client not found")))
                .map(clientMapper::clientToClientDto)
                .log();
    }

    @Override
    public Flux<ClientDto> search(SearchFilter filters) {
        log.info("Search by filters {}", filters);

        return clientService.search(filters)
                .map(clientMapper::clientToClientDto)
                .log();
    }
}
