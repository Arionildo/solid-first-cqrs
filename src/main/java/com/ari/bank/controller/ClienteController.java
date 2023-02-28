package com.ari.bank.controller;

import com.ari.bank.dto.ClienteDTO;
import com.ari.bank.entity.Cliente;
import com.ari.bank.service.command.ClienteCommand;
import com.ari.bank.service.query.ClienteQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteQuery query;
    private final ClienteCommand command;
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        return Optional
                .ofNullable(query.buscar(id))
                .map(cliente -> ResponseEntity.ok(toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@NotEmpty @Valid @RequestBody ClienteDTO dto) {
        command.salvar(toEntity(dto));
        return ResponseEntity.ok().build();
    }

    private Cliente toEntity(ClienteDTO dto) {
        return mapper.map(dto, Cliente.class);
    }

    private ClienteDTO toDTO(Optional<Cliente> cliente) {
        return mapper.map(cliente, ClienteDTO.class);
    }

}
