package CEN4010.project.book_details.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.book_details.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>{
    Optional<Book> findByIsbn(String isbn);
    List<Book> findByAuthorId(Long authorId);
}
