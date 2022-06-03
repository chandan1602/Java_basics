package com.chandan.grpcspringdemo.service;

import com.chandan.grpcspringdemo.GreetingRequest;
import com.chandan.grpcspringdemo.GreetingResponse;
import com.chandan.grpcspringdemo.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Recieved Message : " + message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Recieved Your message : " + message + "Hello From Server.")
                .build();
        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
