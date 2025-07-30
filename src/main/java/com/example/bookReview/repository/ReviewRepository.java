package com.example.bookReview.repository;

import com.example.bookReview.model.Book;
import com.example.bookReview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBookIsbn(String isbn);
}
