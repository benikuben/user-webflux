package ru.neoflex.userwebflux.models.client;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document("client")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @MongoId
    private String id;
    private Long bankId;
    @Indexed
    private String lastName;
    @Indexed
    private String firstName;
    @Indexed
    private String middleName;
    private LocalDate birthdate;
    private String passport;
    private String placeOfBirth;
    @Indexed
    private String phone;
    @Indexed
    private String email;
    private String residentialAddress;
    private String registrationAddress;
}
