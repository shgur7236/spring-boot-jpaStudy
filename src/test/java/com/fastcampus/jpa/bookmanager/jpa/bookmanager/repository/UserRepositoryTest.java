package com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // Create,Read,Update,Delete
        userRepository.save(new User("new martin","newmartin@factcampus.com"));

        userRepository.flush();

        userRepository.findAll().forEach(System.out::println);
    }
}