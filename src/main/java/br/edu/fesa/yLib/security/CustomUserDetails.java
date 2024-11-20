package br.edu.fesa.yLib.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Grupo7
 */
public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private String name;
    private String image;
    private boolean isUsing2FA;

    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private boolean credentialsNonExpired;

    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(
            String email,
            String password,
            String name,
            String image,
            Boolean enabled,
            boolean isUsing2FA,
            Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.image = image;
        this.enabled = enabled;
        this.isUsing2FA = isUsing2FA;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.authorities = authorities;
    }

    public String getImage() {
        return image;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void eraseCredentials() {
        this.password = null;
    }

    public String getInitials() {
        String[] nameParts = name.trim().split("\\s+");

        // Extrai a primeira letra do primeiro e último nome, se disponível
        String firstInitial = nameParts[0].substring(0, 1).toUpperCase();
        String lastInitial = nameParts.length > 1 ? nameParts[nameParts.length - 1].substring(0, 1).toUpperCase() : "";
        String initials = firstInitial + lastInitial;

        // Constrói as iniciais
        return "https://ui-avatars.com/api/?name=" + initials + "&background=d3abff&color=fff&size=128";
    }
}
