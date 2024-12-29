package com.book.management.service;

import com.book.management.Entity.Book;
import com.book.management.Repository.BookRepository;
import com.book.management.Service.BookService;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;

    @Test
    public void addBookSuccessWithNoDataTest(){
        Book book=new Book();
        Mockito.when(bookRepository.save(book)).thenReturn(null);
        Book book1 = bookService.addBook(book);
        Assertions.assertNull(book1);
    }

    @Test
    public void addBookSuccessWithDataTest(){

        //data preparation
        Book book=new Book();
        book.setId(1);
        book.setAuthor("sds");
        book.setGenre("sdssdd");
        book.setTitle("2323");

        // mocking repos
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        //calling actual service
        Book book1 = bookService.addBook(book);

        //asserting result
        Assertions.assertEquals(book,book1);
    }
}
