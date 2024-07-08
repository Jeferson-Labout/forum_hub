package com.laboutapi.aluraforumapi.domain.forum.topico.DTO;

import com.laboutapi.aluraforumapi.domain.course.DTO.DadosCursoCompleto;
import com.laboutapi.aluraforumapi.domain.forum.topico.StatusTopico;
import com.laboutapi.aluraforumapi.domain.forum.topico.Topico;
import com.laboutapi.aluraforumapi.domain.user.DTO.DadosUsuarioCompleto;

import java.time.LocalDateTime;

public record DadosTopicoCompleto(Long id, String titulo, String mensagem,
                                  LocalDateTime dataCriacao, StatusTopico status,
                                  DadosUsuarioCompleto autor, DadosCursoCompleto curso) {
    public DadosTopicoCompleto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getDadosAutor(),
                topico.getDadosCurso()
        );
    }
}
