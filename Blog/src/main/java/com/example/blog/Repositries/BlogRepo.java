package com.example.blog.Repositries;

import com.example.blog.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {
    Blog findBlogById(Integer id);

    List<Blog> findAllByMyUser_IdAndId(Integer myUser_Id, Integer Id);
    Blog findBlogByTitle(String title);

    List<Blog> findAllByMyUser_Id(Integer id);

}
