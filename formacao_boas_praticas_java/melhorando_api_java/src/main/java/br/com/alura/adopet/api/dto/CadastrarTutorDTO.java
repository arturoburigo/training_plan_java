package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarTutorDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String telefone) {
}
