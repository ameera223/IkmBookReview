package com.example.bookReview.repository;

import com.example.bookReview.model.Book;
import com.example.bookReview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    Review findReviewByIsbn(String isbn);
}
