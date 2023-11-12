package ru.neoflex.userwebflux.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.models.client.Client;
import ru.neoflex.userwebflux.models.validation.ValidationSource;
import ru.neoflex.userwebflux.services.impl.ClientAccountServiceImpl;
import ru.neoflex.userwebflux.util.mappers.ClientMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientAccountServiceTest {
    @Mock
    private ClientService clientService;
    @Mock
    private ClientMapper clientMapper;
    @Mock
    private ValidationSourceService validationSourceService;
    @InjectMocks
    private ClientAccountServiceImpl clientAccountService;

    @Test
    void create() {
        ClientDto client = ClientDto.builder().build();
        String sourceName = "source";

        when(validationSourceService.findByName(any()))
                .thenReturn(
                        Mono.empty(),
                        Mono.just(ValidationSource.builder().build())
                );
        when(clientService.save(any())).thenReturn(Mono.just(new Client()));

        StepVerifier.create(clientAccountService.create(client, sourceName))
                .expectError()
                .verify();

        StepVerifier.create(clientAccountService.create(client, sourceName))
                .expectError()
                .verify();
    }

    @Test
    void findById() {
        when(clientService.findById(any())).thenReturn(Mono.empty());

        StepVerifier.create(clientAccountService.findById("1"))
                .expectError()
                .verify();
    }

    @Test
    void search() {
        when(clientService.search(any())).thenReturn(Flux.just(new Client()));

        clientAccountService.search(new SearchFilter());
        verify(clientService, times(1)).search(any());
    }
}