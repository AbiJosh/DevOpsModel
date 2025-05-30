package com.test.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.Domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
