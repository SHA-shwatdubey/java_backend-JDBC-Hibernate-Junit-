package com.capgemini.library.service;

import com.capgemini.library.entity.Author;
import com.capgemini.library.entity.Book;
import com.capgemini.library.entity.Category;
import com.capgemini.library.entity.LibraryBranch;
import com.capgemini.library.exception.ResourceNotFoundException;
import com.capgemini.library.repository.AuthorRepository;
import com.capgemini.library.repository.BookRepository;
import com.capgemini.library.repository.CategoryRepository;
import com.capgemini.library.repository.LibraryBranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final LibraryBranchRepository branchRepository;
    private final AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
    }

    public Book addBook(Book book, Long categoryId, Long branchId, List<Long> authorIds) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
        LibraryBranch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + branchId));
        Set<Author> authors = authorIds.stream()
                .map(id -> authorRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id)))
                .collect(Collectors.toSet());

        book.setCategory(category);
        book.setBranch(branch);
        book.setAuthors(authors);
        book.setStatus("ACTIVE");
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book book) {
        Book existing = getBookById(bookId);
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        existing.setPublishYear(book.getPublishYear());
        existing.setCopiesTotal(book.getCopiesTotal());
        existing.setCopiesAvailable(book.getCopiesAvailable());
        existing.setStatus(book.getStatus());
        return bookRepository.save(existing);
    }

    public void deleteOrDisableBook(Long bookId) {
        Book existing = getBookById(bookId);
        existing.setStatus("INACTIVE");
        bookRepository.save(existing);
    }
}


