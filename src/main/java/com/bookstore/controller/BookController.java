package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "Book management APIs")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    @Operation(summary = "Get all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Create a new book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a book")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 