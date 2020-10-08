package com.rzdp.treeflexauthorizationserver.model;

import com.rzdp.treeflexauthorizationserver.entity.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthUserDetail extends Customer implements UserDetails {

    public AuthUserDetail(Customer customer) {
        super(customer);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        super.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !super.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !super.getAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !super.getCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.getEnabled();
    }
}
