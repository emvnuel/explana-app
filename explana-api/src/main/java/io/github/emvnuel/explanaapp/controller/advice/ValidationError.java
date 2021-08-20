package io.github.emvnuel.explanaapp.controller.advice;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ValidationError extends StandardError {

    private Map<String, String> errors = new HashMap<>();

    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.put(fieldName, message);
    }

}