package ru.neoflex.userwebflux.services;

import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.models.validation.ValidationSource;

public interface ValidationSourceService {
    Mono<ValidationSource> findByName(String name);
}
