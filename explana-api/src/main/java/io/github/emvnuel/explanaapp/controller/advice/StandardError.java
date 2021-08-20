package io.github.emvnuel.explanaapp.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}