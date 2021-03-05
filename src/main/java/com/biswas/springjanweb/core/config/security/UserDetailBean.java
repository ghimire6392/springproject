package com.biswas.springjanweb.core.config.security;

import com.biswas.springjanweb.common.enums.Occupation;
import com.biswas.springjanweb.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class UserDetailBean implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (user.getOccupation() == Occupation.DRIVER_INTELLIGENCE) {
            return AuthorityUtils.createAuthorityList("ROLE_DRIVER_INTELLIGENCE");
        } else if (user.getOccupation() == Occupation.DOCTOR) {
            return AuthorityUtils.createAuthorityList("ROLE_DOCTOR");

        }
        return AuthorityUtils.NO_AUTHORITIES;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
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

    public User getUser() {
        return user;
    }
}
