package com.cognitive.spring.spring5startupwebapp.bootstrap;

import com.cognitive.spring.spring5startupwebapp.model.Author;
import com.cognitive.spring.spring5startupwebapp.model.Book;
import com.cognitive.spring.spring5startupwebapp.repositories.AuthorRepository;
import com.cognitive.spring.spring5startupwebapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class devbootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public devbootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData()
    {
        //Erics

        Author eric = new Author("Eric", "Bana",null);
        Book ericBook = new Book("Domain driven models", "383838", "Harper COllins",null);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        //Dan Bobs
        Author bob = new Author("Dan", "Bob",null);
        Book bobbook = new Book("Microsoft COM+", "3939927", "Microsoft",null);
        bob.getBooks().add(bobbook);
        bobbook.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(bobbook);

    }
}
