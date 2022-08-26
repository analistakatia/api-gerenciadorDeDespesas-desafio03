package com.api.gerenciadorDeContas.exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGerenciadorDeContas extends ResponseEntityExceptionHandler {
    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<String> HttpMessageNotReadableException()


@Data
    public static class MensagemErro{
        private String MensagemDoUsuario;
        private String MensagemDoDev;
}

}






