package com.example.blog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;

    @ManyToOne
    @JoinColumn(name = "myUser_id", referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;

}
