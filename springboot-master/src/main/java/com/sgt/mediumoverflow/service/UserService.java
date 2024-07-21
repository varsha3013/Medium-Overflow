package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<String> registerUser(@RequestBody Map<String,Object> body)
    {




        String full_name=(String) body.get("full_name");
        String username=(String)body.get("username");
        String email=(String)body.get("email");
        String password=(String)body.get("password");
        String dob=(String)body.get("dob");
        String bio=(String)body.get("bio");


        int noOfRows=userRepository.registerUser(full_name,username,email,password,dob,bio);

        if(noOfRows > 0)
        {
            return ResponseEntity.ok(" User is successfully registered");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registration failed");

    }
}
