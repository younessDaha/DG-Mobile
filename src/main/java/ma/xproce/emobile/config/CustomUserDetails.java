package ma.xproce.emobile.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final String nom;
    private final List<GrantedAuthority> role;
    private final String mdps;

    public CustomUserDetails(String nom, List<GrantedAuthority> role, String mdps) {
        this.nom = nom;
        this.role = role;
        this.mdps = mdps;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role;
    }

    @Override
    public String getPassword() {
        return this.mdps;
    }

    @Override
    public String getUsername() {
        return this.nom;
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
