package com.laboutapi.aluraforumapi.domain.user.DTO;

import com.laboutapi.aluraforumapi.domain.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record DadosCadastroUsuario(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{senha.obrigatoria}")
        @Size(min = 4, message = "{senha.invalida}")
        String senha,
        Set<Perfil> perfis) {

    public DadosCadastroUsuario(DadosCadastroUsuario usuario, String senhaCriptografada) {
        this(
                usuario.nome,
                usuario.email,
                senhaCriptografada,
                usuario.perfis
        );
    }
}
