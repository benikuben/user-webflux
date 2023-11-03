package ru.neoflex.userwebflux.services;

import jakarta.validation.Valid;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.models.validation.ValidationRules;

public interface ValidationService {
    void validateRequiredParameters(@Valid ValidationRules validationRules, ClientDto clientDto);
}
