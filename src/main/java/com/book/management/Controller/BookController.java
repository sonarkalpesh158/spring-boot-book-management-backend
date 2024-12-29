package com.book.management.Controller;

import com.book.management.Entity.Book;
import com.book.management.Service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path ="/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        if (book==null){
            return ResponseEntity.badRequest().body(null);
        }
        Book book1 = bookService.addBook(book);
        return ResponseEntity.ok(book1);
    }

    @PutMapping(path ="/update-book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if (book==null){
            return ResponseEntity.badRequest().body(null);
        }
        Book book1 = bookService.updateBook(book);
        return ResponseEntity.ok(book1);
    }

    @GetMapping(path ="/get-book/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name){
        Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @DeleteMapping(path ="/delete-book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id){
       bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
