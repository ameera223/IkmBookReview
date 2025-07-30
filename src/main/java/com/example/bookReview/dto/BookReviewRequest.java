package com.example.bookReview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookReviewRequest {
    private String isbn;
    private String title;
    private String author;
    private String publicationYear;
    private InitialReviewRequest initialReview;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InitialReviewRequest{
        private String reviewerName;
        private int rating;
        private String comment;
    }
}
