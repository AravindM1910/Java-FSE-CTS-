package org.example.service;

import org.example.repository.BookRepository;

// Service layer for Library Management - uses setter-based dependency injection
public class BookService {
    private BookRepository bookRepository;

    // Setter injection - wired via Spring XML configuration
    public void setBookRepository(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    // Delegates to repository to fetch and print the book name
    public void printBookName()
    {
        System.out.println("Book: " + bookRepository.getBookName());
    }
}
