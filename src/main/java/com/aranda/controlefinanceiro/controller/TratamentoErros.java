package com.aranda.controlefinanceiro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class TratamentoErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacao(
            MethodArgumentNotValidException erro) {

        List<String> detalhes = erro.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(campo -> campo.getDefaultMessage())
                .distinct()
                .toList();

        Map<String, Object> resposta = Map.of(
                "erro", "Dados inválidos",
                "detalhes", detalhes
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}