package ru.neoflex.userwebflux.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.models.client.Client;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {
    Client clientDtoToClient(ClientDto clientDto);

    ClientDto clientToClientDto(Client client);
}
