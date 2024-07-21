package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.BlogService;
import com.sgt.mediumoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:49296")

public class UserResource
{

    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,Object> body)
    {
        return userService.registerUser(body);
    }
}
