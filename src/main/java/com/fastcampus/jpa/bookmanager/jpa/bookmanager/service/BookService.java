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
    public void putBookAndAuthor() throws Exception {
        Book book = new Book();
        book.setName("JPA start");

        bookRepository.save(book);


        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

        // RuntimeException은 transaction내에서 발생했을 경우에는 반영 내용이 롤백이 되고,
        // checkedException은 transactional내에서 발생하더라도 반영 내용이 롤백되지 않고 commit된다.
        throw new Exception("오류가 나서 DB commit이 발생하지 않습니다.");
    }




}
