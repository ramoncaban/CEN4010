package CEN4010.project.book_details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import CEN4010.project.book_details.model.Author;
import CEN4010.project.book_details.repo.AuthorRepository;
import CEN4010.project.book_details.service.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    @Autowired
    AuthorRepository repo;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody List<Author> author) {
        repo.saveAll(author);
    }
    
    @GetMapping("/showAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

}
