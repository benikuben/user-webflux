package ru.neoflex.userwebflux.repositories.client;

import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.neoflex.userwebflux.models.client.Client;

public interface ClientRepository extends ReactiveCrudRepository<Client, String>, ReactiveQuerydslPredicateExecutor<Client> {
}
