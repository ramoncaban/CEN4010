package CEN4010.project.book_details.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.book_details.model.Book;
import CEN4010.project.book_details.repo.BookRepo;
import CEN4010.project.book_details.service.BookDetailsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookDetailsController {

    @Autowired
    BookRepo repo;

    @Autowired
    private BookDetailsService bookService;


    @PostMapping("/addBook")
    public void addBook(@RequestBody List<Book> book) {
        repo.saveAll(book);
    }
    
    @GetMapping("/showBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/findByIsbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> book = bookService.getBookByIsbn(isbn);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
