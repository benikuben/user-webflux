package ru.neoflex.userwebflux.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.ErrorResponse;
import ru.neoflex.userwebflux.exceptions.ClientAccountException;
import ru.neoflex.userwebflux.exceptions.ClientValidationException;
import ru.neoflex.userwebflux.exceptions.NotFoundException;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorHandlingControllerAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorResponse> handleInvalidFormatException(InvalidFormatException e) {
        ErrorResponse response = new ErrorResponse(e.getValue() + " - invalid value");
        log.warn("InvalidFormatException {}", response);
        return Mono.just(response);
    }

    @ResponseBody
    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Flux<ErrorResponse> handleWebExchangeBindException(WebExchangeBindException e) {
        List<ErrorResponse> response = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> new ErrorResponse(error.getDefaultMessage()))
                .toList();
        return Flux.fromIterable(response);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Mono<ErrorResponse> handleNotFoundException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        log.warn("NotFoundException {}", response);
        return Mono.just(response);
    }

    @ExceptionHandler(ClientValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Mono<ErrorResponse> handleClientValidationException(ClientValidationException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        log.warn("ClientValidationException {}", response);
        return Mono.just(response);
    }

    @ExceptionHandler(ClientAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Mono<ErrorResponse> handleClientAccountException(ClientAccountException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        log.warn("ClientAccountException {}", response);
        return Mono.just(response);
    }
}
