package ru.neoflex.userwebflux.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.userwebflux.models.validation.ValidationSource;
import ru.neoflex.userwebflux.repositories.validation.ValidationSourceRepository;
import ru.neoflex.userwebflux.services.impl.ValidationSourceServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidationSourceServiceTest {
    @Mock
    private ValidationSourceRepository validationSourceRepository;
    @InjectMocks
    private ValidationSourceServiceImpl validationSourceService;

    @Test
    void findByName() {
        String name = "mail";

        ValidationSource expectedValidationSource = ValidationSource.builder().name(name).build();

        when(validationSourceRepository.findByName(any()))
                .thenReturn(Mono.just(expectedValidationSource));

        StepVerifier.create(validationSourceService.findByName(name))
                .expectNext(expectedValidationSource)
                .verifyComplete();
    }
}