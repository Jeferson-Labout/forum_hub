package com.laboutapi.aluraforumapi.domain.forum.resposta.DTO;

import com.laboutapi.aluraforumapi.domain.forum.topico.Topico;
import com.laboutapi.aluraforumapi.domain.user.Usuario;

public record DadosCompletoCadastroResposta(String mensagem, Usuario autor, Topico topico) {
}
