package ru.neoflex.userwebflux.models.validation;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationRules {
    @NotNull(message = "Validation rule for isBankIdRequired is not specified")
    private Boolean isBankIdRequired;
    @NotNull(message = "Validation rule for isLastNameRequired is not specified")
    private Boolean isLastNameRequired;
    @NotNull(message = "Validation rule for isFirstNameRequired is not specified")
    private Boolean isFirstNameRequired;
    @NotNull(message = "Validation rule for isMiddleNameRequired is not specified")
    private Boolean isMiddleNameRequired;
    @NotNull(message = "Validation rule for isBirthdateRequired is not specified")
    private Boolean isBirthdateRequired;
    @NotNull(message = "Validation rule for isPassportRequired is not specified")
    private Boolean isPassportRequired;
    @NotNull(message = "Validation rule for isPlaceOfBirthRequired is not specified")
    private Boolean isPlaceOfBirthRequired;
    @NotNull(message = "Validation rule for isPhoneRequired is not specified")
    private Boolean isPhoneRequired;
    @NotNull(message = "Validation rule for isEmailRequired is not specified")
    private Boolean isEmailRequired;
    @NotNull(message = "Validation rule for isResidentialAddressRequired is not specified")
    private Boolean isResidentialAddressRequired;
    @NotNull(message = "Validation rule for isRegistrationAddressRequired is not specified")
    private Boolean isRegistrationAddressRequired;
}
