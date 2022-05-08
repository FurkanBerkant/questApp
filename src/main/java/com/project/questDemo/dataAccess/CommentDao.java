package com.project.questDemo.dataAccess;

import com.project.questDemo.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}
