package CEN4010.project.BookRating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.BookRating.model.BookRating;

public interface BookRatingRepository extends JpaRepository<BookRating, Long> {

    public List<BookRating> findByBookId(Long book_id);

}
