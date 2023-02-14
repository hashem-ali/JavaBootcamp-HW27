package com.example.blog.Services;


import com.example.blog.Models.MyUser;
import com.example.blog.Repositries.MyUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MyUserRepo myUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepo.findMyUserByUsername(username);
        if(myUser == null){
            throw new UsernameNotFoundException("Wrong UserName or password");
        }

        return myUser;
    }
}
