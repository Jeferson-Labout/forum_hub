package com.laboutapi.aluraforumapi.domain.forum.topico.DTO;

import com.laboutapi.aluraforumapi.domain.course.Curso;
import com.laboutapi.aluraforumapi.domain.user.Usuario;

public record DadosCompletoCadastroTopico(String titulo, String mensagem, Usuario autor, Curso curso) {
}
