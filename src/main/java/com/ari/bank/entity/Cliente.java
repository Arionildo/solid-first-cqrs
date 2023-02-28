package com.ari.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_cliente")
    private Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String cpf;

    @Column(nullable = false)
    LocalDate dataNascimento;

    @Column(nullable = false)
    String endereco;

    LocalDateTime dataAtualizacao;
}
