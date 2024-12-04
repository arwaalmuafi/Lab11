package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUsersByUserId(Integer userId);

    User findUsersByUsername(String username);

    User findUsersByEmail(String email);


}
