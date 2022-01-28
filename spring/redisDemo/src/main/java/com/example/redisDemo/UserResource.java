package com.example.redisDemo;

import com.example.redisDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {
    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {
       return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable String id,
            @RequestBody String name) {
        return userService.updateUser(id, name);
    }

    @GetMapping("")
    public Map<String, User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }


}
