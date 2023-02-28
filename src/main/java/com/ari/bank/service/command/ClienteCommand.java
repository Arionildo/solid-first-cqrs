package com.ari.bank.service.command;

import com.ari.bank.entity.Cliente;
import com.ari.bank.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ClienteCommand {

    private final ClienteRepository repository;

    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        cliente.setDataAtualizacao(LocalDateTime.now());
        return repository.save(cliente);
    }
}
