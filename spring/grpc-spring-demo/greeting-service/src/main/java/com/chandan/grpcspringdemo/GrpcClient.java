package com.chandan.grpcspringdemo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost", 9090)
                        .usePlaintext()
                        .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreetingResponse response =
                stub.greeting(GreetingRequest.newBuilder()
                        .setMessage("Testing Phase. ")
                        .build());

        channel.shutdown();
    }
}
