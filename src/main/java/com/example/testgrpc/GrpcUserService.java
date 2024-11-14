package com.example.testgrpc;

import com.example.testgrpc.entity.UserEntity;
import com.example.testgrpc.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GrpcService
public class GrpcUserService extends UserServiceGrpc.UserServiceImplBase {

    private UserRepository userRepository;

    @Autowired
    public GrpcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserOuterClass.CreateUserRequest request, StreamObserver<UserOuterClass.CreateUserResponse> responseObserver) {

        UserEntity userEntity = new UserEntity();

        UserOuterClass.User user = request.getUser();
        userEntity.setRole(user.getRole());
        userEntity.setName(user.getName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
        System.out.println("User saved");

        responseObserver.onNext(UserOuterClass.CreateUserResponse.newBuilder()
                .setId(userEntity.id)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UserOuterClass.UpdateUserRequest request, StreamObserver<UserOuterClass.UpdateUserResponse> responseObserver) {

        UserOuterClass.User user = request.getUser();

        UserEntity userEntity = userRepository.findById(user.getId());

        if (!user.getName().isEmpty()) {
            userEntity.setName(request.getUser().getName());
        }
        userEntity.setRole(user.getRole());
        if (!user.getUsername().isEmpty()) {
            userEntity.setUsername(user.getUsername());
        }
        if (!user.getPassword().isEmpty()) {
            userEntity.setPassword(user.getPassword());
        }
        userRepository.save(userEntity);
        System.out.println("User updated");

        responseObserver.onNext(UserOuterClass.UpdateUserResponse.newBuilder()
                .setId(userEntity.id)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(UserOuterClass.GetUserRequest request, StreamObserver<UserOuterClass.GetUserResponse> responseObserver) {

        UserEntity userEntity = userRepository.findById(request.getId());
        UserOuterClass.User user = new UserOuterClass.User().toBuilder().setId(
                userEntity.id
        ).setRole(
                userEntity.getRole()
        ).setName(
                userEntity.getName()
        ).setUsername(
                userEntity.getUsername()
        ).setPassword(
                userEntity.getPassword()
        ).build();

        System.out.println("User retrieved: " + user);

        responseObserver.onNext(UserOuterClass.GetUserResponse.newBuilder()
                .setUser(user)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(UserOuterClass.DeleteUserRequest request, StreamObserver<UserOuterClass.DeleteUserResponse> responseObserver) {

        UserEntity userEntity = userRepository.findById(request.getId());
        userRepository.delete(userEntity);
        System.out.println("User deleted (id): " + request.getId());

        responseObserver.onNext(UserOuterClass.DeleteUserResponse.newBuilder()
                .setId(request.getId())
                .build());
        responseObserver.onCompleted();
    }

}
