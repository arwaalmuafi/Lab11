package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUSer(User user){
        userRepository.save(user);
    }


    public void updateUser(Integer userId,User user){
        User oldUSer=userRepository.findUsersByUserId(userId);

        if(oldUSer==null){
            throw new ApiException("user not found");
        }

        oldUSer.setUsername(user.getUsername());
        oldUSer.setEmail(user.getEmail());
        oldUSer.setPassword(user.getPassword());
        userRepository.save(oldUSer);
    }

    public void deleteUser(Integer userId){
        User user=userRepository.findUsersByUserId(userId);
        if(user==null){
            throw new ApiException("user not found");
        }

        userRepository.delete(user);
    }

    //1
    public User findUserById(Integer userId){
        User user=userRepository.findUsersByUserId(userId);
        if(user==null){
            throw new  ApiException("user not found");
        }

        return user;
    }

    //2
    public User findUserByUsername(String username){
        User user1=userRepository.findUsersByUsername(username);

        if(user1==null){
            throw new ApiException("user not found");
        }
        return user1;
    }

    //3
    public User findUserByEmail(String email){
        User user=userRepository.findUsersByEmail(email);
        if(user== null){
            throw new ApiException("user not found");
        }
        return user;
    }


}
