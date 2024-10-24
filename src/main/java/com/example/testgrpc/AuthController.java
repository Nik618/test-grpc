package com.example.testgrpc;


import com.example.testgrpc.dto.JwtRequestDto;
import com.example.testgrpc.dto.JwtResponseDto;
import com.example.testgrpc.dto.RefreshJwtRequestDto;
import com.example.testgrpc.dto.UserDto;
import com.example.testgrpc.entity.UserEntity;
import com.example.testgrpc.repository.UserRepository;
import com.example.testgrpc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody JwtRequestDto authRequest) throws Exception {
        JwtResponseDto token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponseDto> getNewAccessToken(@RequestBody RefreshJwtRequestDto request) throws Exception {
        JwtResponseDto token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("sign")
    public ResponseEntity<String> sign(@RequestBody UserDto request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getLogin());
        userEntity.setName(request.getName());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole("USER");
        userRepository.save(userEntity);
        return ResponseEntity.ok("200 OK");
    }
}
