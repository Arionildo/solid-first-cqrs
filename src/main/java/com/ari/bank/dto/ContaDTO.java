package com.ari.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ContaDTO {
    Long id;
    @NonNull
    String agencia;
    @NonNull
    String numero;
    @NonNull
    String digito;
    @NonNull
    ClienteDTO titular;
    BigDecimal saldo;
}
