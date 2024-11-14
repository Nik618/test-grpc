package com.example.testgrpc;

import com.example.testgrpc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestGrpcApplication {

    @Autowired
    private static UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(TestGrpcApplication.class, args);
    }

}
