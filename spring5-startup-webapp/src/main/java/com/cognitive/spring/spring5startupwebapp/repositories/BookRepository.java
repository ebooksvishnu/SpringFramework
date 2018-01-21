package com.cognitive.spring.spring5startupwebapp.repositories;

import com.cognitive.spring.spring5startupwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book,Long>{

}
