package com.cognitive.spring.spring5startupwebapp.bootstrap;

import com.cognitive.spring.spring5startupwebapp.model.Author;
import com.cognitive.spring.spring5startupwebapp.model.Book;
import com.cognitive.spring.spring5startupwebapp.model.Publisher;
import com.cognitive.spring.spring5startupwebapp.repositories.AuthorRepository;
import com.cognitive.spring.spring5startupwebapp.repositories.BookRepository;
import com.cognitive.spring.spring5startupwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class devbootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public devbootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData()
    {
        //Erics

        Author eric = new Author("Eric", "Bana");

        //adding publisher here.
        Publisher harper = new Publisher("Harper Collins", "London, UK");

        Book ericBook = new Book("Domain driven models", "383838", harper);


        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);
        //adding publisher
        //harper.setBookName(ericBook);


        authorRepository.save(eric);
        //saving publisher
        publisherRepository.save(harper);
        bookRepository.save(ericBook);


        //Dan Bobs
        Author bob = new Author("Dan", "Bob");
        //Add book publisher
        Publisher microsoft = new Publisher("Microsoft", "Seattle, USA");

        Book bobbook = new Book("Microsoft COM+", "3939927",microsoft);
        bob.getBooks().add(bobbook);
        bobbook.getAuthors().add(bob);
        //Set publisher
        //microsoft.setBookName(bobbook);

        authorRepository.save(bob);
        //save publisher
        publisherRepository.save(microsoft);
        bookRepository.save(bobbook);

    }
}
