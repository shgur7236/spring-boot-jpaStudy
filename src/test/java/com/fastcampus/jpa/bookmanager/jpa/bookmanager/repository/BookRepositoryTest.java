package com.fastcampus.jpa.bookmanager.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.Review;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Jpa 초격화 패키지");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());

    }

    private void givenBookAndReview(){
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("제피에이 초겨화");
        book.setPublisher(publisher);

       return bookRepository.save(book);


    }
    private User givenUser(){
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private void givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("도라ㅔ몽");
        review.setContent("너무너무 재미있음 ㅋ");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);

    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("fastcampus");

        return publisherRepository.save(publisher);
    }

}
