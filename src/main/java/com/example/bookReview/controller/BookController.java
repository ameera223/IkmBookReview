package com.example.bookReview.controller;


import com.example.bookReview.dto.BookReviewRequest;
import com.example.bookReview.model.Book;
import com.example.bookReview.model.Review;
import com.example.bookReview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook( BookReviewRequest bookReviewRequest){
        Book book = new Book();
        book.setIsbn(bookReviewRequest.getIsbn());
        book.setTitle(bookReviewRequest.getTitle());
        book.setAuthor(bookReviewRequest.getAuthor());
        book.setPublicationYear(bookReviewRequest.getPublicationYear());

        Review initialReview = new Review();
        initialReview.setReviewerName(bookReviewRequest.getInitialReview().getReviewerName());
        initialReview.setRating(bookReviewRequest.getInitialReview().getRating());
        initialReview.setComment(bookReviewRequest.getInitialReview().getComment());

        return bookService.createBook(book,initialReview);
    }

    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }
}
