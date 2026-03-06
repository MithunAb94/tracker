package com.expense.tracker.service;

import com.expense.tracker.contract.LoginRequest;
import com.expense.tracker.contract.RegisterRequest;
import com.expense.tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    public User register(RegisterRequest request){

        if(userService.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user=new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        return userService.createUser(user);
    }

    public User login(LoginRequest request){

        User user=userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
