package com.ogawalucas.springexamples.infra.config;

import com.ogawalucas.springexamples.app.dto.error.FieldValidation;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerConfig {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldValidation> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
            .stream()
            .map(fieldError -> new FieldValidation(fieldError.getField(), messageSource.getMessage(fieldError, getLocale())))
            .toList();
    }
}
