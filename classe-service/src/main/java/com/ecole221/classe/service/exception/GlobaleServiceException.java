package com.ecole221.classe.service.exception;

import com.ecole221.classe.service.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobaleServiceException {

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
    @ExceptionHandler(ClassNotFoundException.class)
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





}
