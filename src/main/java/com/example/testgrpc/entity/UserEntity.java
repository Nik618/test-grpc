package com.example.testgrpc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String accessToken;
    @Setter
    @Getter
    private String refreshToken;
    @Setter
    @Getter
    private String role;

}
