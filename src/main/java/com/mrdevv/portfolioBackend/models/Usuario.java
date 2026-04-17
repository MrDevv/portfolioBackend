package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    Long usuarioId;

    @Column(name = "usuario_uuid")
    UUID usuarioUUID = UUID.randomUUID();

    String email;

    String password;

    Boolean estado;

    @OneToOne
    @JoinColumn(name = "desarrollador_id")
    Desarrollador desarrollador;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    Rol rol;

    @Column(name = "api_key")
    String apiKey;

    @Column(name = "origen_permitido")
    String origenPermitido;

    @Column(name = "estado_origen")
    Boolean estadoOrigen;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.descripcion));
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
}
