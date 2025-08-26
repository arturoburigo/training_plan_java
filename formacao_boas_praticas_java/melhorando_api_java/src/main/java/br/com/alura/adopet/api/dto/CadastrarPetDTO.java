package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarPetDTO(@NotNull TipoPet tipo, @NotNull String nome, @NotNull String raca, @NotNull Integer idade,
                              @NotBlank String cor) {
}
