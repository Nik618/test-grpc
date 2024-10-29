package com.example.testgrpc.service;

import com.example.testgrpc.dto.RoleEnum;
import com.example.testgrpc.dto.UserDto;
import com.example.testgrpc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDto> getByLogin(String login) {
        return userRepository.findAllByUsername(login).stream()
                .map(entity -> new UserDto(entity.getUsername(), entity.getPassword(), entity.getName(), entity.getRole() != null ? Set.of(RoleEnum.valueOf(entity.getRole())) : Set.of()))
                .findFirst();
    }
}
