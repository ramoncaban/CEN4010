package CEN4010.project.BookRating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.BookRating.model.BookComment;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {

    public List<BookComment> findByBookIdOrderByCreatedAtDesc(Long book_id);

}