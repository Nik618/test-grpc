package com.example.testgrpc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequestDto {
    private String login;
    private String password;

    public JwtRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
