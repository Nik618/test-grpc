package com.example.testgrpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.testgrpc.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserOuterClass.CreateUserRequest,
      UserOuterClass.CreateUserResponse> METHOD_CREATE_USER =
      io.grpc.MethodDescriptor.<UserOuterClass.CreateUserRequest, UserOuterClass.CreateUserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.testgrpc.UserService", "CreateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.CreateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.CreateUserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserOuterClass.GetUserRequest,
      UserOuterClass.GetUserResponse> METHOD_GET_USER =
      io.grpc.MethodDescriptor.<UserOuterClass.GetUserRequest, UserOuterClass.GetUserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.testgrpc.UserService", "GetUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.GetUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.GetUserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserOuterClass.UpdateUserRequest,
      UserOuterClass.UpdateUserResponse> METHOD_UPDATE_USER =
      io.grpc.MethodDescriptor.<UserOuterClass.UpdateUserRequest, UserOuterClass.UpdateUserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.testgrpc.UserService", "UpdateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.UpdateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.UpdateUserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserOuterClass.DeleteUserRequest,
      UserOuterClass.DeleteUserResponse> METHOD_DELETE_USER =
      io.grpc.MethodDescriptor.<UserOuterClass.DeleteUserRequest, UserOuterClass.DeleteUserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.testgrpc.UserService", "DeleteUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.DeleteUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserOuterClass.DeleteUserResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(UserOuterClass.CreateUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.CreateUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_USER, responseObserver);
    }

    /**
     */
    public void getUser(UserOuterClass.GetUserRequest request,
                        io.grpc.stub.StreamObserver<UserOuterClass.GetUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER, responseObserver);
    }

    /**
     */
    public void updateUser(UserOuterClass.UpdateUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.UpdateUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_USER, responseObserver);
    }

    /**
     */
    public void deleteUser(UserOuterClass.DeleteUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.DeleteUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_USER, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                UserOuterClass.CreateUserRequest,
                UserOuterClass.CreateUserResponse>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            METHOD_GET_USER,
            asyncUnaryCall(
              new MethodHandlers<
                UserOuterClass.GetUserRequest,
                UserOuterClass.GetUserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            METHOD_UPDATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                UserOuterClass.UpdateUserRequest,
                UserOuterClass.UpdateUserResponse>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            METHOD_DELETE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                UserOuterClass.DeleteUserRequest,
                UserOuterClass.DeleteUserResponse>(
                  this, METHODID_DELETE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(UserOuterClass.CreateUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.CreateUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(UserOuterClass.GetUserRequest request,
                        io.grpc.stub.StreamObserver<UserOuterClass.GetUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(UserOuterClass.UpdateUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.UpdateUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(UserOuterClass.DeleteUserRequest request,
                           io.grpc.stub.StreamObserver<UserOuterClass.DeleteUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public UserOuterClass.CreateUserResponse createUser(UserOuterClass.CreateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_USER, getCallOptions(), request);
    }

    /**
     */
    public UserOuterClass.GetUserResponse getUser(UserOuterClass.GetUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER, getCallOptions(), request);
    }

    /**
     */
    public UserOuterClass.UpdateUserResponse updateUser(UserOuterClass.UpdateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_USER, getCallOptions(), request);
    }

    /**
     */
    public UserOuterClass.DeleteUserResponse deleteUser(UserOuterClass.DeleteUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_USER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserOuterClass.CreateUserResponse> createUser(
        UserOuterClass.CreateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserOuterClass.GetUserResponse> getUser(
        UserOuterClass.GetUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserOuterClass.UpdateUserResponse> updateUser(
        UserOuterClass.UpdateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserOuterClass.DeleteUserResponse> deleteUser(
        UserOuterClass.DeleteUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_GET_USER = 1;
  private static final int METHODID_UPDATE_USER = 2;
  private static final int METHODID_DELETE_USER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((UserOuterClass.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<UserOuterClass.CreateUserResponse>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((UserOuterClass.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<UserOuterClass.GetUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((UserOuterClass.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<UserOuterClass.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((UserOuterClass.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<UserOuterClass.DeleteUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return UserOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_USER)
              .addMethod(METHOD_GET_USER)
              .addMethod(METHOD_UPDATE_USER)
              .addMethod(METHOD_DELETE_USER)
              .build();
        }
      }
    }
    return result;
  }
}
