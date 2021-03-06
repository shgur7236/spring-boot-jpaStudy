package com.fastcampus.jpa.bookmanager.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA start");

        bookRepository.save(book);


        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);
    }




}
