package CEN4010.project.BookRating.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class BookRating {

    @Id
    private Long id;

    private Long userId;

    private Long bookId;

    private Integer rating;

    //private Timestamp created_At;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
}
