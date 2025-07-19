package com.example.repository;

import com.example.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    User findUserByEmail(String email);
    User findUserByPhone(String phone);

}
