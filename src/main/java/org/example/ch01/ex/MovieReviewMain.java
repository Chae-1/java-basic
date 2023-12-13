package org.example.ch01.ex;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.review = "인생은 무한 루프";
        inception.title = "인셉션";

        MovieReview review2 = new MovieReview();
        review2.review = "인생 시간 영화";
        review2.title = "어바웃 타임";

        MovieReview[] movieReviews = {inception, review2};

        for (MovieReview review : movieReviews) {
            System.out.println("영화 제목 : " + review.title + ", 리뷰 : " + review.review);
        }

    }
}
