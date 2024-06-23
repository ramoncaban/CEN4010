package CEN4010.project.book_details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.book_details.model.Book;
import CEN4010.project.book_details.repo.BookRepo;
import CEN4010.project.book_details.service.BookDetailsService;

import org.springframework.web.bind.annotation.GetMapping;
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

}
