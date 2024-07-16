package CEN4010.project.Book_Browsing_and_Sorting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.Book_Browsing_and_Sorting.Models.Books;
import CEN4010.project.Book_Browsing_and_Sorting.Service.BookService;



@RestController


public class BookController {
    
    @Autowired
    private BookService bookService;
 
    
    @GetMapping("/books")
    public List<Books> getBooksByGenre(@RequestParam String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/top10soldbooks")
    public List<Books> getTop10SoldBooks(){
        return bookService.getTop10SoldBooks();
    }


    @GetMapping("/GreaterThanEqual")
    public List<Books> getBooksByRating(@RequestParam double rating) {
        return bookService.getBooksByRating(rating); //updated
    }

    @PutMapping("/DiscountByPublisher")
    public ResponseEntity<String> discountByPrice(@RequestParam String publisher, double discount){

        bookService.discountByPublisher(publisher, discount);
        return ResponseEntity.ok("Discount Applied Successfully");
    }
    
    
    
    
    

   
    
    
}
