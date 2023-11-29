package ru.neoflex.userwebflux.services.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.exceptions.UserException;
import ru.neoflex.userwebflux.models.client.Client;
import ru.neoflex.userwebflux.repositories.client.ClientRepository;
import ru.neoflex.userwebflux.services.ClientService;
import ru.neoflex.userwebflux.util.QPredicates;

import static ru.neoflex.userwebflux.models.client.QClient.client;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Flux<Client> search(SearchFilter filters) {
        Predicate predicates = QPredicates.builder()
                .add(filters.getLastName(), client.lastName::containsIgnoreCase)
                .add(filters.getFirstName(), client.firstName::containsIgnoreCase)
                .add(filters.getMiddleName(), client.middleName::containsIgnoreCase)
                .add(filters.getPhone(), client.phone::containsIgnoreCase)
                .add(filters.getEmail(), client.email::containsIgnoreCase)
                .buildAnd();
        if (predicates == null) {
            throw new UserException("At least one search field must be specified");
        }
        return clientRepository.findAll(predicates);
    }
}
