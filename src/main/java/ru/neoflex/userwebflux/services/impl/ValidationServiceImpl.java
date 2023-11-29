package ru.neoflex.userwebflux.services.impl;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.exceptions.UserValidationException;
import ru.neoflex.userwebflux.models.validation.ValidationRules;
import ru.neoflex.userwebflux.services.ValidationService;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@Slf4j
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateRequiredParameters(@Valid ValidationRules validationRule, ClientDto clientDto) {
        List<String> message = new ArrayList<>();

        if (validationRule.getIsBankIdRequired())
            if (clientDto.getBankId() == null)
                message.add("Required parameter 'bank_id' is omitted");
        if (validationRule.getIsLastNameRequired())
            if (StringUtils.isBlank(clientDto.getLastName()))
                message.add("Required parameter 'last_name' is omitted");
        if (validationRule.getIsFirstNameRequired())
            if (StringUtils.isBlank(clientDto.getFirstName()))
                message.add("Required parameter 'first_name' is omitted");
        if (validationRule.getIsMiddleNameRequired())
            if (StringUtils.isBlank(clientDto.getMiddleName()))
                message.add("Required parameter 'middle_name' is omitted");
        if (validationRule.getIsBirthdateRequired())
            if (clientDto.getBirthdate() == null)
                message.add("Required parameter 'birthdate' is omitted");
        if (validationRule.getIsPassportRequired())
            if (StringUtils.isBlank(clientDto.getPassport()))
                message.add("Required parameter 'passport' is omitted");
        if (validationRule.getIsPlaceOfBirthRequired())
            if (StringUtils.isBlank(clientDto.getPlaceOfBirth()))
                message.add("Required parameter 'place_of_birth' is omitted");
        if (validationRule.getIsPhoneRequired())
            if (StringUtils.isBlank(clientDto.getPhone()))
                message.add("Required parameter 'phone' is omitted");
        if (validationRule.getIsEmailRequired())
            if (StringUtils.isBlank(clientDto.getEmail()))
                message.add("Required parameter 'email' is omitted");
        if (validationRule.getIsResidentialAddressRequired())
            if (StringUtils.isBlank(clientDto.getResidentialAddress()))
                message.add("Required parameter 'residential_address' is omitted");
        if (validationRule.getIsRegistrationAddressRequired())
            if (StringUtils.isBlank(clientDto.getRegistrationAddress()))
                message.add("Required parameter 'registration_address' is omitted");

        if (message.size() > 0) {
            throw new UserValidationException(message.toString());
        }
    }
}
