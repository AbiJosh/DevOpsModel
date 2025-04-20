package com.test.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Domain.User;
import com.test.demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public User validate(String username,String password){
        return repo.findByUsernameAndPassword(username,password);
    }
}
