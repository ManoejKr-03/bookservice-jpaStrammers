package com.example.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookservice.entity.Books;
import com.example.bookservice.repo.RepositoryBook;

@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    private RepositoryBook repositoryBook;


    @PostMapping("/books")
    public Books addBook(@RequestBody Books book)
    {
        return repositoryBook.save(book);
    }

    @GetMapping("/books/{bid}")
    public Books getAbook(@PathVariable("bid") long bid)
    {
        return repositoryBook.findById(bid).get();
    }


    @GetMapping("/books")
    public List<Books> getAllBooks()
    {
        return repositoryBook.findAll();
    }

    
}
