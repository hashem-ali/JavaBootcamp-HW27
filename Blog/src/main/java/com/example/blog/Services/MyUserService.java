package com.example.blog.Services;

import com.example.blog.Models.MyUser;
import com.example.blog.Repositries.MyUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepo myUserRepo;

    public void register(MyUser myUser ){
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepo.save(myUser);

    }
}
