package com.ari.bank.service.query;

import com.ari.bank.entity.Cliente;
import com.ari.bank.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteQuery {

    private final ClienteRepository repository;

    public Optional<Cliente> buscar(Long id) {
        return repository.findById(id);
    }
}
