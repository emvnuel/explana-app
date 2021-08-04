package io.github.emvnuel.explanaapp.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation Error","One or more fields contain incorrect values.", request.getRequestURI());
        e.getBindingResult().getFieldErrors()
                .stream()
                .forEach(fieldError -> err.addError(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> validation(ConstraintViolationException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation Error", "One or more fields contain incorrect values.", request.getRequestURI());
        e.getConstraintViolations()
                .stream()
                .forEach(violation -> err.addError(violation.getPropertyPath().toString(), violation.getMessage()));
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

}