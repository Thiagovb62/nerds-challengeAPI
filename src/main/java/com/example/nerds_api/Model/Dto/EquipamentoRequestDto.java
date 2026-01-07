package com.example.nerds_api.Model.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema
public record EquipamentoRequestDto(

    @Min(value = 1, message = "Número de série deve ser maior que zero")
    @NotNull(message = "Número de série é obrigatório")
    Long numeroSerie,
    @NotBlank(message = "Nome do equipamento é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9 _-]+$", message = "Nome contém caracteres inválidos")
    String nome,
    @NotBlank(message = "Tipo de equipamento é obrigatório")
    String tipo

) {

}
