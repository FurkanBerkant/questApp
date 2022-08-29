package com.example.questapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "text")
    private String text;
    @Column(name = "title")
    private String title;


}
