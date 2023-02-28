package com.ari.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping
@Slf4j
public class TesteController {

    @GetMapping
    public String teste() {
        String mensagem = "a api está funcionando. " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        log.debug(mensagem);
        return mensagem;
    }
}
