package com.cognitive.spring.spring5startupwebapp.repositories;

import com.cognitive.spring.spring5startupwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
