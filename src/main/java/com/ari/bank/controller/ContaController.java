package com.ari.bank.controller;

import com.ari.bank.dto.ContaDTO;
import com.ari.bank.entity.Conta;
import com.ari.bank.exception.ContaNaoEncontradaExcpetion;
import com.ari.bank.service.query.ContaQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {

    private final ContaQuery query;
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscar(@PathVariable Long id) {
        Optional<Conta> conta = query.buscar(id);

        if (conta.isPresent()) {
            return ResponseEntity.ok(toDTO(conta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<BigDecimal> verificarSaldo(@PathVariable Long id) {
        try {
            BigDecimal saldo = query.verificarSaldo(id);
            return ResponseEntity.ok(saldo);
        } catch (ContaNaoEncontradaExcpetion e) {
            return ResponseEntity.notFound().build();
        }
    }

    private Conta toEntity(ContaDTO dto) {
        return mapper.map(dto, Conta.class);
    }

    private ContaDTO toDTO(Optional<Conta> conta) {
        return mapper.map(conta, ContaDTO.class);
    }
}
