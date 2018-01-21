package com.cognitive.spring.spring5startupwebapp.controllers;

import com.cognitive.spring.spring5startupwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books",this.bookRepository.findAll());
        return "books";
    }
}
