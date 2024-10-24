package com.example.testgrpc.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
