package com.example.blog.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;


//    public String getPassword(){
//        return this.password;
//    }
//    public void setPassword(String password){
//        this.password = password;
//    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myUser")
    private List<Blog> blogs;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
