package com.laboutapi.aluraforumapi.domain.course.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosCursoAtualizar(
        @NotNull(message = "{id.obrigatorio}")
        Long id,
        String nome,
        String categoria) {
}
