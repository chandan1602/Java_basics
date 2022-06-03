package com.devproblems.service;


import com.devproblems.Author;
import com.devproblems.AuthorId;
import com.devproblems.RoutingServiceGrpc;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RemoteService {
    @GrpcClient("grpc-devproblems-service")
    RoutingServiceGrpc.RoutingServiceBlockingStub synchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int id) {
        AuthorId authorId = AuthorId.newBuilder().setId(id).build();
        Author author = synchronousClient.getAuthorById(authorId);
        return author.getAllFields();
    }
}
