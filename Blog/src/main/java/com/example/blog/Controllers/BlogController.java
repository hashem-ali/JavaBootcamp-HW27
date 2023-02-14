package com.example.blog.Controllers;

import com.example.blog.Exceptions.ApiResponse;
import com.example.blog.Models.Blog;
import com.example.blog.Models.MyUser;
import com.example.blog.Services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/blog/")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("getBlog")
    public ResponseEntity<List<Blog>> getBlogs(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getAllBlogs(myUser));
    }

    @PostMapping("addBlog")
    public ResponseEntity<ApiResponse> addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog){
        blogService.addBlog(blog, myUser);
      return  ResponseEntity.ok().body(new ApiResponse("Blog Added", 201));
    }
    @PutMapping("UpdateBlog/{id}")
    public ResponseEntity<ApiResponse> updateBlog(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer id, @RequestBody Blog blog){
        blogService.updateBlog(id, myUser,blog);
        return ResponseEntity.ok().body(new ApiResponse("Blog Updated", 201));
    }

    @DeleteMapping("deleteBlog/{id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer id){
        blogService.deleteBlog(id, myUser);
        return ResponseEntity.ok().body("Blog deleted");
    }
    @PutMapping("user/{userId}/blog/{blogId}")
    public ResponseEntity assignBlogWithUser(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer userId, @PathVariable Integer blogId){
        blogService.assignBlogWithUser(userId,myUser ,blogId);
        return ResponseEntity.status(200).body("Assigned");
    }

}
