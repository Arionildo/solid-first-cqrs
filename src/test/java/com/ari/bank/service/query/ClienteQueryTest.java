package com.ari.bank.service.query;

import com.ari.bank.entity.Cliente;
import com.ari.bank.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteQueryTest {

    @InjectMocks
    private ClienteQuery query;

    @Mock
    private ClienteRepository repository;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .cpf("111.222.333-44")
                .dataNascimento(LocalDate.of(1990,12,31))
                .endereco("Rua Teste, 123")
                .nome("Teste")
                .build();
    }

    @Test
    void dadoId_QuandoBuscar_EntaoRetornaCliente() {
        Long id = 1L;
        cliente.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        Optional<Cliente> clienteObtido = query.buscar(id);

        assertNotNull(clienteObtido);
        assertEquals(clienteObtido, Optional.of(cliente));
    }
}
