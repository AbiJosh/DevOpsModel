package com.modelexam.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelexam.model.Domain.User;
import com.modelexam.model.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public User validate(String username, String password) {
        return repo.findByUsernameAndPassword(username,password);
    }
}
