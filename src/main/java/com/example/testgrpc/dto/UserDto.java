package com.example.testgrpc.dto;

import java.util.Set;

public class UserDto {
    private String login;
    private String password;
    private String name;
    private Set<RoleEnum> roles;

    public UserDto(String login, String password, String name, Set<RoleEnum> roles) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }
}
