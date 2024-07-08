package com.laboutapi.aluraforumapi.domain.course.DTO;

import com.laboutapi.aluraforumapi.domain.course.Curso;

public record DadosListagemCurso(String nome, String categoria) {
    public DadosListagemCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
