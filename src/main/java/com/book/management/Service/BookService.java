package com.book.management.Service;

import com.book.management.Entity.Book;
import com.book.management.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;
    private static final Logger logger= LoggerFactory.getLogger(BookService.class);
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)  // which means needs a new trasaction of itself whether the calling method has its own trasaction active
   // REQUIRED is by default so no need to write it , CREATE NEW TRSCTN
    //NESTED - it rollback partially
    // NEVER - gives exception as calling method has trasanction and this says i don't want trasaction and you are calling me for trsctn
    // SUPPORTS - means if calling method has no trnsctn then calle method will not have the same . if calling method has trsnctn, then callee method will continue the same
   //NOT_SUPPORTED  - which skips the tranaction from calling method whosoever is calling that method
//    @Transactional(propagation = Propagation.MANDATORY) // which means it should have active trasaction of calling method // joins existing trasaction
    public Book addBook(Book book) {
        logger.info("book {}", book.toString());
        logger.info("book is added ");
        return bookRepository.save(book);

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
