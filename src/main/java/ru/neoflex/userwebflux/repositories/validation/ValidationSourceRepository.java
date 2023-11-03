package ru.neoflex.userwebflux.repositories.validation;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.models.validation.ValidationSource;

public interface ValidationSourceRepository extends ReactiveCrudRepository<ValidationSource, String> {
    Mono<ValidationSource> findByName(String name);
}
