package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

@Value
public class CompanyRequest {

    @NotEmpty
    String name;

    @NotEmpty
    String description;

    @URL
    String imageUrl;

}
