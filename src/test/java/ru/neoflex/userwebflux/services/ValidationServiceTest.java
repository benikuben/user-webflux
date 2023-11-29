package ru.neoflex.userwebflux.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.exceptions.UserValidationException;
import ru.neoflex.userwebflux.models.validation.ValidationRules;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ValidationServiceTest {
    @Autowired
    private ValidationService validationService;

    @Test
    void validateRequiredParameters() {
        ValidationRules validationRules = ValidationRules.builder()
                .isBankIdRequired(false)
                .isLastNameRequired(false)
                .isFirstNameRequired(true)
                .isMiddleNameRequired(false)
                .isBirthdateRequired(false)
                .isPassportRequired(false)
                .isPlaceOfBirthRequired(false)
                .isPhoneRequired(false)
                .isEmailRequired(true)
                .isResidentialAddressRequired(false)
                .isRegistrationAddressRequired(false)
                .build();

        ClientDto client1 = ClientDto.builder()
                .email("ivan@mail.ru")
                .build();
        assertThrows(UserValidationException.class, () -> validationService.validateRequiredParameters(validationRules, client1));

        ClientDto client2 = ClientDto.builder()
                .firstName("Ivan")
                .build();
        assertThrows(UserValidationException.class, () -> validationService.validateRequiredParameters(validationRules, client2));
    }
}