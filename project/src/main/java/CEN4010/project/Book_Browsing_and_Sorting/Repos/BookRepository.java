package CEN4010.project.Book_Browsing_and_Sorting.Repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.Book_Browsing_and_Sorting.Models.Books;



public interface BookRepository extends JpaRepository <Books,Long> {
    List <Books> findByGenre(String genre);
    List <Books> findTop10ByOrderBySoldcopiesDesc();
    List <Books> findByRatingGreaterThanEqual(double rating); //Sorting by rating

    
}

