package com.ecole221.classe.service.exception;

import com.ecole221.classe.service.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobaleServiceException {

    private final View error;

    public GlobaleServiceException(View error) {
        this.error = error;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception exception) {
        return ErrorDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClasseServiceNotFoundException.class)
    public ErrorDto handleException(ClasseServiceNotFoundException exception){
        return ErrorDto.builder()
                .code(HttpStatus.NOT_FOUND.value()+"")
                .message(exception.getMessage())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClasseServiceException.class)
    public ErrorDto handleException(ClasseServiceException exception){
        return ErrorDto.builder()
                .code(HttpStatus.BAD_REQUEST.value()+"")
                .message(exception.getMessage())
                .build();
    }

    //Cette méthode va retourner l'ensemble des erreurs de champs.
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationsException(MethodArgumentNotValidException exception){
        // Map interface Java qui permet de représenter une collection de paires de clé
        //Ici les paires de clefs sont de type String,String
        Map<String,String> errors = new HashMap<>();
        //récupère toutes les exceptions de la table et les parcours
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            //pour chaque errors on récupère le field (nom champs) et le message par défaut qui correspond
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        return errors;
    }






}
