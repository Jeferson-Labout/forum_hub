package com.laboutapi.aluraforumapi.domain.user;

import com.laboutapi.aluraforumapi.domain.enums.Perfil;
import com.laboutapi.aluraforumapi.domain.user.DTO.DadosCadastroUsuario;
import com.laboutapi.aluraforumapi.domain.user.DTO.DadosUsuarioAtualizar;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Table(name = "usuarios")
@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "perfil")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario(DadosCadastroUsuario dadosUsuario) {
        this.nome = dadosUsuario.nome();
        this.email = dadosUsuario.email();
        this.senha = dadosUsuario.senha();
        addPerfil(Perfil.USUARIO); // Adiciona perfil padrão
    }

    public void atualizar(DadosUsuarioAtualizar dadosUsuario) {
        if (dadosUsuario.nome() != null) {
            this.nome = dadosUsuario.nome();
        }
        if (dadosUsuario.senha() != null) {
            this.senha = dadosUsuario.senha();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPerfis().stream()
                .map(perfil -> new SimpleGrantedAuthority(perfil.getDescricao()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream()
                .map(Perfil::toEnum)
                .collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }
}
