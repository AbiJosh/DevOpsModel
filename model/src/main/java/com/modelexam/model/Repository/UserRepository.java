package com.modelexam.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelexam.model.Domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsernameAndPassword(String username,String password);
}
