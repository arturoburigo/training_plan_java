package br.com.alura.codechella.infra.dto;

import java.time.LocalDate;

public record UserDTO(
        String cpf,
        String nome,
        LocalDate nascimento,
        String email
) {
}
