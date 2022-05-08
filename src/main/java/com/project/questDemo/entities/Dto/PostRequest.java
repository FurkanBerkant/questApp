package com.project.questDemo.entities.Dto;

import lombok.Data;

@Data
public class PostRequest {

    private int userId;
    private String title;
    private String text;

}
