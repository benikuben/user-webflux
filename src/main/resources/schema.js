db.validation_source.insertMany(
    [
        {
            "name": "mail",
            "rules": {
                "isBankIdRequired": false,
                "isLastNameRequired": false,
                "isFirstNameRequired": true,
                "isMiddleNameRequired": false,
                "isBirthdateRequired": false,
                "isPassportRequired": false,
                "isPlaceOfBirthRequired": false,
                "isPhoneRequired": false,
                "isEmailRequired": true,
                "isResidentialAddressRequired": false,
                "isRegistrationAddressRequired": false
            }
        },
        {
            "name": "mobile",
            "rules": {
                "isBankIdRequired": false,
                "isLastNameRequired": false,
                "isFirstNameRequired": false,
                "isMiddleNameRequired": false,
                "isBirthdateRequired": false,
                "isPassportRequired": false,
                "isPlaceOfBirthRequired": false,
                "isPhoneRequired": true,
                "isEmailRequired": false,
                "isResidentialAddressRequired": false,
                "isRegistrationAddressRequired": false
            }
        },
        {
            "name": "bank",
            "rules": {
                "isBankIdRequired": true,
                "isLastNameRequired": true,
                "isFirstNameRequired": true,
                "isMiddleNameRequired": true,
                "isBirthdateRequired": true,
                "isPassportRequired": true,
                "isPlaceOfBirthRequired": false,
                "isPhoneRequired": false,
                "isEmailRequired": false,
                "isResidentialAddressRequired": false,
                "isRegistrationAddressRequired": false
            }
        },
        {
            "name": "gosuslugi",
            "rules": {
                "isBankIdRequired": true,
                "isLastNameRequired": true,
                "isFirstNameRequired": true,
                "isMiddleNameRequired": true,
                "isBirthdateRequired": true,
                "isPassportRequired": true,
                "isPlaceOfBirthRequired": true,
                "isPhoneRequired": true,
                "isEmailRequired": false,
                "isResidentialAddressRequired": false,
                "isRegistrationAddressRequired": true
            }
        }
    ]
)
