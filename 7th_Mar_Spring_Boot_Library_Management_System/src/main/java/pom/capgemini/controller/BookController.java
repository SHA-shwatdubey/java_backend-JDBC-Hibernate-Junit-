package pom.capgemini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pom.capgemini.entity.Book;
import pom.capgemini.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Tag(name = "Books", description = "Book management APIs")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all books"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved book"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/available")
    @Operation(summary = "Get available books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved available books"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }

    @GetMapping("/search/title/{title}")
    @Operation(summary = "Search books by title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching books"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    @GetMapping("/search/author/{author}")
    @Operation(summary = "Search books by author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching books"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }

    @PostMapping
    @Operation(summary = "Add new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}


