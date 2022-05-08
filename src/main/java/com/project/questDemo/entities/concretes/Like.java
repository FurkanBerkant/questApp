package com.project.questDemo.entities.concretes;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "like")
public class Like {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
