package com.laboutapi.aluraforumapi.domain.user.DTO;

import com.laboutapi.aluraforumapi.domain.enums.Perfil;
import com.laboutapi.aluraforumapi.domain.user.Usuario;

import java.util.Set;

public record DadosUsuarioCompleto(Long id, String nome, String email, Set<Perfil> perfis) {
    public DadosUsuarioCompleto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfis()
        );
    }
}
