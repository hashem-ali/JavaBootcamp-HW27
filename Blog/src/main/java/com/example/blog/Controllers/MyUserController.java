package com.example.blog.Controllers;

import com.example.blog.Exceptions.ApiResponse;
import com.example.blog.Models.MyUser;
import com.example.blog.Services.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/myUser")
public class MyUserController {
    private final MyUserService myUserService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody MyUser myUser){
        myUserService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User registered !",201));
    }

    @PostMapping("/admin")
    public ResponseEntity<ApiResponse> admin(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back ADMIN",200));
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back user",200));
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back",200));
    }
}
