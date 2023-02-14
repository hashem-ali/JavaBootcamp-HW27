package com.example.blog.Repositries;

import com.example.blog.Models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);
}
