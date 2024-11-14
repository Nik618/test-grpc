package com.example.testgrpc;

import com.example.testgrpc.repository.UserRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GrpcServer {

    private GrpcUserService grpcUserService; //TODO
    private UserRepository userRepository;

    @Autowired
    public GrpcServer(GrpcUserService grpcUserService, UserRepository userRepository) {
        this.grpcUserService = grpcUserService;
        this.userRepository = userRepository;
    }

    //@Bean //TODO
    private void start() throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9091)
                .addService(new GrpcUserService(userRepository)).build();

        server.start();
        server.awaitTermination();
    }

}
