package com.example.testgrpc.service;


import com.example.testgrpc.dto.JwtRequestDto;
import com.example.testgrpc.dto.JwtResponseDto;
import com.example.testgrpc.dto.UserDto;
import com.example.testgrpc.entity.UserEntity;
import com.example.testgrpc.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final JwtProviderService jwtProviderService;
    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserService userService, JwtProviderService jwtProviderService, UserRepository userRepository) {
        this.userService = userService;
        this.jwtProviderService = jwtProviderService;
        this.userRepository = userRepository;
    }

    public JwtResponseDto login(JwtRequestDto authRequest) throws Exception {
        UserDto user = userService.getByLogin(authRequest.getLogin()).orElseThrow(() -> new Exception("User not found"));
        System.out.println(user.getLogin());
        if (user.getPassword().equals(authRequest.getPassword())) {
            String accessToken = jwtProviderService.generateAccessToken(user);
            String refreshToken = jwtProviderService.generateRefreshToken(user);
            UserEntity userEntity = userRepository.findByUsername(user.getLogin());
            userEntity.setRefreshToken(refreshToken);
            userRepository.save(userEntity);
            return new JwtResponseDto("Bearer", accessToken, refreshToken);
        } else {
            throw new Exception("Incorrect password");
        }
    }

    public JwtResponseDto getAccessToken(String refreshToken) throws Exception {
        if (jwtProviderService.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProviderService.getRefreshClaims(refreshToken);
            String login = claims.getSubject();
            String savedRefreshToken = userRepository.findByUsername(login).getRefreshToken();
            if (savedRefreshToken != null && savedRefreshToken.equals(refreshToken)) {
                UserDto user = userService.getByLogin(login).orElseThrow(() -> new Exception("User not found"));
                String accessToken = jwtProviderService.generateAccessToken(user);
                String newRefreshToken = jwtProviderService.generateRefreshToken(user);
                UserEntity userEntity = userRepository.findByUsername(user.getLogin());
                userEntity.setRefreshToken(newRefreshToken);
                userEntity.setAccessToken(accessToken);
                userRepository.save(userEntity);
                return new JwtResponseDto("Bearer", accessToken, newRefreshToken);
            }
        }
        return new JwtResponseDto(null, null, null);
    }

}
