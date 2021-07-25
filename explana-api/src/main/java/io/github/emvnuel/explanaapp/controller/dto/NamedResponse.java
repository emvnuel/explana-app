package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;

@Value
public class NamedResponse<T> {

    private T id;
    private String name;

}
