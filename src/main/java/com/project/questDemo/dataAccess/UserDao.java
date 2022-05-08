package com.project.questDemo.dataAccess;

import com.project.questDemo.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);
}
