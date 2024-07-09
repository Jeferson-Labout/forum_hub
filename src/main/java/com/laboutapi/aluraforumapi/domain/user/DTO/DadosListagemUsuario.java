package com.laboutapi.aluraforumapi.domain.user.DTO;

import java.util.Set;

import com.laboutapi.aluraforumapi.domain.enums.Perfil;
import com.laboutapi.aluraforumapi.domain.user.Usuario;

public record DadosListagemUsuario(String nome, String email,Set<Perfil> perfis ) {
    public DadosListagemUsuario(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfis()
        );
    }
}
