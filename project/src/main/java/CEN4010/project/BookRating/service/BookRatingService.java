package CEN4010.project.BookRating.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CEN4010.project.BookRating.model.BookComment;
import CEN4010.project.BookRating.model.BookRating;
import CEN4010.project.BookRating.repo.BookCommentRepository;
import CEN4010.project.BookRating.repo.BookRatingRepository;



public class BookRatingService {

    @Autowired
    private BookRatingRepository bookRatingsRepository;
    @Autowired
    private BookCommentRepository bookCommentsRepository;

    public void createRating(Long book_id, Long user_id, Integer rating) {
        BookRating bookRating = new BookRating();
        bookRating.setUserId(user_id);
        bookRating.setBookId(book_id);
        bookRating.setRating(rating);
        bookRatingsRepository.save(bookRating);
    }

    public void createComment(Long book_id, Long user_id, String comment) {
        BookComment bookComment = new BookComment();
        bookComment.setUserId(user_id);
        bookComment.setBookId(book_id);
        bookComment.setComment(comment);
        bookCommentsRepository.save(bookComment);
    }

    public List<BookComment> getcomment(Long book_id) {
        return (bookCommentsRepository.findByBookIdOrderByCreatedAtDesc(book_id));
    }

    public Double getAverageRating(Long book_id) {
        List<BookRating> ratings = bookRatingsRepository.findByBookId(book_id);
        double sum = 0;
        for (BookRating rating : ratings) {
            sum += rating.getRating();
        }
        return (double) sum / ratings.size();
    }
}
