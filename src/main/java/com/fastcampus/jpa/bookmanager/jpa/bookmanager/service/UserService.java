package com.fastcampus.jpa.bookmanager.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

    }
}
