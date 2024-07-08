package CEN4010.project.BookRating.model;

import jakarta.persistence.Id;

public class BookComment {

    @Id
    private Long id;

    private Long userId;

    private Long bookId;

    private String comment;

    ///private Timestamp createdAt;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
