package CEN4010.project.book_details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEN4010.project.book_details.model.Author;
import CEN4010.project.book_details.repo.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
