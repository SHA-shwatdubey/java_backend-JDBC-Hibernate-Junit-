package com.capgemini.library.service;

import com.capgemini.library.entity.Author;
import com.capgemini.library.exception.ResourceNotFoundException;
import com.capgemini.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long authorId, Author author) {
        Author existing = getAuthorById(authorId);
        existing.setName(author.getName());
        existing.setBiography(author.getBiography());
        return authorRepository.save(existing);
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}


