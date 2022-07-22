package com.fastcampus.jpa.bookmanager.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    private UserRepository userRepository;

    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

//        userRepository.save(user);

        entityManager.persist(user);
    }
}
