package com.example.redisDemo;

import com.example.redisDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Service
public class UserService {
    private UserRepositoryImpl userRepository;

    @Autowired
    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.save(new User(user.getId(), user.getName(), 20000L));
        return userRepository.findById(user.getId());
    }

    public User updateUser(String id, String name) {
        userRepository.update(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    public Map<String, User> getUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = "itemCache")
    public User getUserById(String id) {
        return userRepository.findById(id);
    }
}
