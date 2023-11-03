package ru.neoflex.userwebflux.models.validation;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "validation_source")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationSource {
    @Id
    private String id;
    private String name;
    private ValidationRules rules;
}
