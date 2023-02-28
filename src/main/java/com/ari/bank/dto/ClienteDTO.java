package com.ari.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ClienteDTO {
    Long id;
    @NonNull
    String nome;
    @NonNull
    String cpf;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataNascimento;
    @NonNull
    String endereco;
    LocalDateTime dataAtualizacao;
}
