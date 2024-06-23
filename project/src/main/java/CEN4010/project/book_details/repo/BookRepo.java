package CEN4010.project.book_details.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.book_details.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}
