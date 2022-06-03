package com.devproblems.controller;

import com.devproblems.service.RemoteService;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class RemoteController {
    RemoteService remoteService;

    @GetMapping("/author/{authorId}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String authorId) {
        return remoteService.getAuthor(Integer.parseInt(authorId));
    }
}
