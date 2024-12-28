package com.book.management.Service;

import com.book.management.Entity.Book;
import com.book.management.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;
    private static final Logger logger= LoggerFactory.getLogger(BookService.class);
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        logger.info("book {}", book);
        if (book==null){
            return null;
        }else {
            return bookRepository.save(book);

        }
    }

    public Book getBookByName(String name) {
        return bookRepository.findBookByTitle(name);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
