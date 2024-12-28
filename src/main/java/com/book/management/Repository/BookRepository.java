package com.book.management.Repository;

import com.book.management.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,Integer> {
    public Book findBookByTitle(String name);
}
