package CEN4010.project.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CEN4010.project.wishlist.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}