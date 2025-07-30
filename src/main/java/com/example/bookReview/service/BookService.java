package com.example.bookReview.service;

import com.example.bookReview.model.Book;
import com.example.bookReview.model.Review;
import com.example.bookReview.repository.BookRepository;
import com.example.bookReview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public Book createBook(Book book, Review review){
        bookRepository.save(book);
        review.setBook(book);
        review.setReviewDate(LocalDate.now());
        reviewRepository.save(review);
        book.getReviews().add(review);
        return book;
    }

    public Map<String, Object> getBookByIsbn(String isbn){
        Book book =bookRepository.findByIsbn(isbn);
        List<Review> reviews = reviewRepository.findByBookIsbn(isbn);
        double averageRating = reviews.stream().mapToInt(Review::getRating).average().orElse(0);

        return Map.of()
                "book": book,
        "reviews": reviews,
        "averageRating": averageRating,
        "reviewCount": reviews.size(),


    }

}
