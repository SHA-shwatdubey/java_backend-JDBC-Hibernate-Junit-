package com.capgemini.library.controller;

import com.capgemini.library.entity.Book;
import com.capgemini.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book,
                                           @RequestParam Long categoryId,
                                           @RequestParam Long branchId,
                                           @RequestParam List<Long> authorIds) {
        return new ResponseEntity<>(bookService.addBook(book, categoryId, branchId, authorIds), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrDisableBook(@PathVariable Long id) {
        bookService.deleteOrDisableBook(id);
        return ResponseEntity.noContent().build();
    }
}


