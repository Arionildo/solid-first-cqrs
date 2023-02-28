package com.ari.bank.service.query;

import com.ari.bank.entity.Conta;
import com.ari.bank.exception.ContaNaoEncontradaExcpetion;
import com.ari.bank.repository.ContaRepository;
import com.ari.bank.service.ContaQueryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContaQuery implements ContaQueryInterface {

    private final ContaRepository repository;

    @Override
    public Optional<Conta> buscar(Long id) {
        return repository.findById(id);
    }

    @Override
    public BigDecimal verificarSaldo(Long idConta) throws ContaNaoEncontradaExcpetion {
        Optional<Conta> conta = buscar(idConta);

        if (conta.isPresent()) {
            return conta.get().getSaldo();
        } else {
            throw new ContaNaoEncontradaExcpetion();
        }
    }
}
