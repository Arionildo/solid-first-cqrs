package com.ari.bank.service.command;

import com.ari.bank.entity.Cliente;
import com.ari.bank.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteCommandTest {

    @InjectMocks
    private ClienteCommand command;

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
    void dadoCliente_QuandoSalvar_EntaoSucesso() {
        command.salvar(cliente);
        verify(repository, times(1)).save(any());
    }

    @Test
    void dadoCliente_QuandoAtualizar_EntaoRetornaClienteAtualizado() {
        cliente.setId(1L);
        cliente.setEndereco("Av. Teste");

        when(repository.save(cliente)).thenReturn(cliente);
        Cliente clienteObtido = command.atualizar(cliente);

        assertNotNull(cliente.getDataAtualizacao());
        assertEquals(cliente, clienteObtido);
    }
}
