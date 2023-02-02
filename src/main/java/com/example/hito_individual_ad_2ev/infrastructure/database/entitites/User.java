package com.example.hito_individual_ad_2ev.infrastructure.database.entitites;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Serial
    private static final long serialVersionUID = 4740354443699664604L;
    @ToString.Include
    @Id
    @Column(name = "email", nullable = false, length = 500)
    private String email;

    @ToString.Include
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @ToString.Include
    @Column(name = "password", nullable = false, length = 500)
    private String pass;

    @ToString.Include
    @Column(name = "role", nullable = false, length = 500)
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks = new LinkedHashSet<>();

    public User(String email, String name, String pass, String role) {
        this.email = email;
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return pass;

    }

    @Override
    public String getUsername() {
        return email;
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