package CEN4010.project.BookRating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.BookRating.model.BookComment;
import CEN4010.project.BookRating.model.BookRating;
import CEN4010.project.BookRating.service.BookRatingService;

@RestController
@RequestMapping("/api/books")
public class BookRatingController {
    
    @Autowired
    private BookRatingService bookRatingService;

    @PostMapping("/{book_id}/rate")
    public ResponseEntity<Void> createRating(@PathVariable Long book_id, @RequestBody BookRating ratingRequest) {
        bookRatingService.createRating(book_id, ratingRequest.getUserId(), ratingRequest.getRating());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{book_id}/comment")
    public ResponseEntity<Void> createComment(@PathVariable Long book_id, @RequestBody BookComment commentRequest) {
        bookRatingService.createComment(book_id, commentRequest.getUserId(), commentRequest.getComment());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{book_id}/comment")
    public ResponseEntity<List<BookComment>> getcomment(@PathVariable Long book_id) {
        List<BookComment> comment = bookRatingService.getcomment(book_id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/{book_id}/rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long book_id) {
        Double averageRating = bookRatingService.getAverageRating(book_id);
        return ResponseEntity.ok(averageRating);
    }
}
