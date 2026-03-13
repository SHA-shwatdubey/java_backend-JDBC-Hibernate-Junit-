package pom.capgemini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pom.capgemini.entity.Book;
import pom.capgemini.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public Book createBook(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new RuntimeException("Book with ISBN already exists: " + book.getIsbn());
        }

        if (book.getAvailable() == null) {
            book.setAvailable(true);
        }

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);

        if (!book.getIsbn().equals(bookDetails.getIsbn())
                && bookRepository.existsByIsbn(bookDetails.getIsbn())) {
            throw new RuntimeException("Book with ISBN already exists: " + bookDetails.getIsbn());
        }

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setAvailable(bookDetails.getAvailable());

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}


