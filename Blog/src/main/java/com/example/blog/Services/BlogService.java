package com.example.blog.Services;

import com.example.blog.Exceptions.ApiException;
import com.example.blog.Exceptions.ApiResponse;
import com.example.blog.Models.Blog;
import com.example.blog.Models.MyUser;
import com.example.blog.Repositries.BlogRepo;
import com.example.blog.Repositries.MyUserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepo blogRepo;
    private final MyUserRepo myUserRepo;

    public List<Blog> getAllBlogs(MyUser myUser){
        return blogRepo.findAllByMyUser_Id(myUser.getId());
    }

    public void addBlog(Blog blog, MyUser user){
        blog.setMyUser(user);
        blog.getMyUser().setId(user.getId());
        blogRepo.save(blog);
    }

    public void updateBlog(Integer id, MyUser user,Blog blog){
        Blog oldBlog = blogRepo.findBlogById(id);
        if(blog == null || blog.getMyUser().getId() != user.getId()){
            throw new ApiException("Not Found");
        }
        blog.setMyUser(user);
        blog.setId(oldBlog.getId());
        blogRepo.save(blog);
    }

    public void deleteBlog(Integer id, MyUser user){
        Blog blog = blogRepo.findById(id).get();
        System.out.println(blog.getMyUser().getId()+" "+ user.getId());
//        System.out.println(blog+" " + user);
        if(blog == null || blog.getMyUser().getId() != user.getId()){
            throw new ApiException("Not Found");
        }
        if( blog.getMyUser().getId() == user.getId()) {
            blogRepo.deleteById(blog.getId());
        }

    }
    public void assignBlogWithUser(Integer userId,MyUser myUser ,Integer blogId){
        MyUser user = myUserRepo.findMyUserById(userId);
        Blog blog = blogRepo.findBlogById(blogId);
        if(blog == null ||user == null || myUser.getId() != blog.getMyUser().getId()){
            throw new ApiException("Not Found");
        }
//        if(myUser.getId() == )
        blog.setMyUser(user);
        blogRepo.save(blog);
    }

    public Blog getBlogByTitle(Integer userId, String title){
        MyUser user = myUserRepo.findMyUserById(userId);
        Blog blog = blogRepo.findBlogByTitle(title);
        if(blog.getMyUser().getId() == userId){
            return blog;
        }
        if(blog == null || user == null){
            throw new ApiException("Not Found");
        }
        return null;
    }

    public Blog findBlogById(Integer blogId, Integer userId){
        MyUser user = myUserRepo.findMyUserById(userId);
        Blog blog = blogRepo.findBlogById(blogId);
        if(blog.getMyUser().getId() == userId){
            return blog;
        }
        if(blog == null || user == null){
            throw new ApiException("Not Found");
        }
        return null;
    }

    public List<Blog> getAllUserBlogs(Integer userId, Integer blogId){
        List<Blog> blog = blogRepo.findAllByMyUser_IdAndId(userId, blogId);
        if(blog == null){
            throw new ApiException("Not Found");
        }
        return blog;
    }
}
