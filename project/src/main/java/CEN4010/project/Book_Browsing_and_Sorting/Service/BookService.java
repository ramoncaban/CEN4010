package CEN4010.project.Book_Browsing_and_Sorting.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEN4010.project.Book_Browsing_and_Sorting.Models.Books;
import CEN4010.project.Book_Browsing_and_Sorting.Repos.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    

    public List<Books> getBooksByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }

    public List<Books> getTop10SoldBooks(){
        return bookRepository.findTop10ByOrderBySoldcopiesDesc();
    }

    public List<Books> getBooksByRating(double rating) {
        List <Books> greaterThan = bookRepository.findByRatingGreaterThan(rating);
        List <Books> equalToBooks = bookRepository.findByRating(rating);

        equalToBooks.removeAll(greaterThan);
        greaterThan.addAll(equalToBooks);

        return greaterThan;
    }


}
