package com.example.Library_management_system.service.impl;

import com.example.Library_management_system.entity.Author;
import com.example.Library_management_system.entity.Book;
import com.example.Library_management_system.repository.AuthorRepository;
import com.example.Library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        author.getBooks().add(book); // book add to the list

        book.setAuthor(author); // set book to the particular author

        authorRepository.save(author);
        return "Book added";

    }
}
