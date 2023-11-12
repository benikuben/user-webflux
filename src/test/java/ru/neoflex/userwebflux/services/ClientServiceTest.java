package ru.neoflex.userwebflux.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.exceptions.ClientAccountException;
import ru.neoflex.userwebflux.models.client.Client;
import ru.neoflex.userwebflux.repositories.client.ClientRepository;
import ru.neoflex.userwebflux.services.impl.ClientServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void save() {
        Client client = Client.builder()
                .bankId(1L)
                .lastName("Ivanov")
                .firstName("Ivan")
                .middleName("Ivanovich")
                .birthdate(LocalDate.of(2000, 1, 1))
                .passport("1111 111111")
                .placeOfBirth("Moscow")
                .phone("79999999999")
                .email("ivan@mail.ru")
                .registrationAddress("Moscow")
                .residentialAddress("Moscow")
                .build();

        Client expectedClient = new Client();
        BeanUtils.copyProperties(client, expectedClient);
        expectedClient.setId("1");

        when(clientRepository.save(any())).thenReturn(Mono.just(expectedClient));

        StepVerifier.create(clientService.save(client))
                .expectNext(expectedClient)
                .verifyComplete();
    }

    @Test
    void findById() {
        String id = "1";

        Client expectedClient = Client.builder().id(id).build();

        when(clientRepository.findById((String) any()))
                .thenReturn(Mono.just(expectedClient));

        StepVerifier.create(clientService.findById(id))
                .expectNext(expectedClient)
                .verifyComplete();
    }

    @Test
    void search() {
        SearchFilter filters = new SearchFilter();
        assertThrows(ClientAccountException.class, () -> clientService.search(filters));
    }
}