package com.api.gerenciadorDeContas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGerenciadorDeContas extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ContaNaoLocalizadaException.class})
    public @ResponseBody
    String handlerBusinessRules(ContaNaoLocalizadaException exception) {

        return "Conta não localizada no sistema.";
    }
}






