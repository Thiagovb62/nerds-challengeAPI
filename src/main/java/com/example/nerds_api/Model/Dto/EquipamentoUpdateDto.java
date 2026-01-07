package com.example.nerds_api.Model.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema
public record EquipamentoUpdateDto(

    @Size(max = 50, message = "Nome deve ter no máximo 100 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9 _-]+$", message = "Nome contém caracteres inválidos")
    String nome,
    String tipo

) {

}
