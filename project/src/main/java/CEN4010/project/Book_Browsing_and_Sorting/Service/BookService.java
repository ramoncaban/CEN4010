package CEN4010.project.Book_Browsing_and_Sorting.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEN4010.project.Book_Browsing_and_Sorting.Models.Books;
import CEN4010.project.Book_Browsing_and_Sorting.Repos.BookRepository;
import jakarta.transaction.Transactional;

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

    public List<Books> getBooksByRating(double rating){
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    @Transactional
    public void discountByPublisher(String publisher, double discount){
        List<Books> books = bookRepository.findByPublisher(publisher);
        
        for(Books book: books){
            double newPrice = book.getPrice() * (1 - discount / 100.0);
            book.setPrice(newPrice);
        }
        bookRepository.saveAll(books);
    }


}
