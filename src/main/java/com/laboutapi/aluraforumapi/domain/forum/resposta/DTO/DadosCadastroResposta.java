package com.laboutapi.aluraforumapi.domain.forum.resposta.DTO;

import com.laboutapi.aluraforumapi.domain.forum.topico.Topico;
import com.laboutapi.aluraforumapi.domain.user.Usuario;

public record DadosCadastroResposta(String mensagem, Long autor, Long topico) {
}
