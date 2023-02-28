package com.ari.bank.service;

import com.ari.bank.entity.Conta;
import com.ari.bank.exception.ContaNaoEncontradaExcpetion;

import java.math.BigDecimal;
import java.util.Optional;

public interface ContaQueryInterface {
    Optional<Conta> buscar(Long id);
    BigDecimal verificarSaldo(Long idConta) throws ContaNaoEncontradaExcpetion;
}
