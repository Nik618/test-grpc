package com.example.testgrpc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponseDto {
    private String type;
    private String accessToken;
    private String refreshToken;

    public JwtResponseDto(String type, String accessToken, String refreshToken) {
        this.type = type;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
