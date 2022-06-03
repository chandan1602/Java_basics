package com.devproblems.controller;

import com.devproblems.*;
import com.devproblems.service.BookAuthorClientService;
import com.google.protobuf.Descriptors;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Map;


@GrpcService
@AllArgsConstructor
public class BookAuthorController extends RoutingServiceGrpc.RoutingServiceImplBase {
    BookAuthorClientService bookAuthorClientService;

//    @GetMapping("/author/{authorId}")
//    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String authorId) {
//        return bookAuthorClientService.getAuthor(Integer.parseInt(authorId));
//    }

//    @GetMapping("/book/{authorId}")
//    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthor(@PathVariable String authorId) throws InterruptedException {
//        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(authorId));
//    }

//    @GetMapping("/book")
//    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
//        return bookAuthorClientService.getExpensiveBook();
//    }

//    @GetMapping("/book/author/{gender}")
//    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthorGender(@PathVariable String gender) throws InterruptedException {
//        return bookAuthorClientService.getBooksByAuthorGender(gender);
//    }

    @Override
    public void getAuthorById(AuthorId request, StreamObserver<Author> responseObserver) {
        responseObserver.onNext(bookAuthorClientService.getAuthor(request.getId()));
        responseObserver.onCompleted();
    }

//    @Override
//    public void getBooksByAuthorId(AuthorId request, StreamObserver<Book> responseObserver) throws InterruptedException {
//        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(request.getId()));
//    }
//
//    @Override
//    public void getMostExpensiveBook(Empty request, StreamObserver<BookName> responseObserver) throws InterruptedException {
//        return bookAuthorClientService.getExpensiveBook();
//    }
//
//    @Override
//    public void getBooksByAuthorGender(Gender request, StreamObserver<Book> responseObserver) throws InterruptedException {
//        return bookAuthorClientService.getBooksByAuthorGender(request.getType());
//    }
}
