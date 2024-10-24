package com.example.testgrpc.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id; //TODO getters!

    @Setter
    public String username;
    @Setter
    public String password;
    @Setter
    public String name;
    @Setter
    public String accessToken;
    @Setter
    public String refreshToken;
    @Setter
    public String role;

}
