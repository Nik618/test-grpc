package com.example.testgrpc;

import com.example.testgrpc.dto.RoleEnum;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class JwtAuthentication implements Authentication {

    private boolean authenticated;
    @Setter
    private String username;
    @Setter
    private String firstName;
    private Set<RoleEnum> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return firstName;
    }

    public void setRoles(ArrayList<String> roles) {
        Set<RoleEnum> roleEnums = new java.util.HashSet<>();
        for (String role : roles) {
            roleEnums.add(RoleEnum.valueOf(role));
        }
        this.roles = roleEnums;
    }

}
