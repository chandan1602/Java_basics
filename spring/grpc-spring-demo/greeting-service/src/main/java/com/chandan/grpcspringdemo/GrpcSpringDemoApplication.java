package com.chandan.grpcspringdemo;

import com.chandan.grpcspringdemo.service.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcSpringDemoApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcSpringDemoApplication.class, args);
//		Server server = ServerBuilder.forPort(9090).addService(new GreetingServiceImpl()).build();
//		server.start();
//		System.out.println("Server started at " + server.getPort());
//		server.awaitTermination();
	}
}
