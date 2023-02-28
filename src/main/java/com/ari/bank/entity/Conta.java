package com.ari.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "conta")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Conta implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_conta")
    private Long id;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String digito;

    @Column(nullable = false)
    private Cliente titular;

    private BigDecimal saldo;
}
