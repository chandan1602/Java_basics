package com.example.mybatisdemo.resource;


import com.example.mybatisdemo.mappers.UsersMapper;
import com.example.mybatisdemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    @Autowired
    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/update")
    public List<Users> update() {
        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(2333L);
        usersMapper.insert(users);
        return usersMapper.findAll();
    }
}
