package com.project.questDemo.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user",schema = "public")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;
}
