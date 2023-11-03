package ru.neoflex.userwebflux.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.models.validation.ValidationSource;
import ru.neoflex.userwebflux.repositories.validation.ValidationSourceRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ValidationSourceServiceImpl implements ru.neoflex.userwebflux.services.ValidationSourceService {
    private final ValidationSourceRepository validationSourceRepository;

    public Mono<ValidationSource> findByName(String name) {
        return validationSourceRepository.findByName(name);
    }
}
