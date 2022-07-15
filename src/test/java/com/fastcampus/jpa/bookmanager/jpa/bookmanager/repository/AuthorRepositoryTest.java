package com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    void manyToManyTest(){

    }



}
