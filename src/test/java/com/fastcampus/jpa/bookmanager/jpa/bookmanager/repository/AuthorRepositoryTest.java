package com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Book;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    void manyToManyTest(){
        Book book1 = givenBook("혼자가 되는 과정");
        Book book2 = givenBook("하나이면서 둘인 것");
        Book book3 = givenBook("개발자란?");
        Book book4 = givenBook("개발자의 세계");

        Author author1 = givenAuthor("노혁");
        Author author2 = givenAuthor("곽희상");

        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author1,author2);
        book4.addAuthor(author1,author2);

        author1.addBook(book1,book3,book4);
        author2.addBook(book2,book3,book4);

        bookRepository.saveAll(Lists.newArrayList(book1,book2,book3,book4));
        authorRepository.saveAll(Lists.newArrayList(author1,author2));



    }

    private Book givenBook(String name){
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name){
        Author author = new Author();
        author.setName(name);

        return authorRepository.save(author);
    }

}
