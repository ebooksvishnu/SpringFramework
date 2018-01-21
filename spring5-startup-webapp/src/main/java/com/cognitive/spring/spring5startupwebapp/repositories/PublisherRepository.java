package com.cognitive.spring.spring5startupwebapp.repositories;

import com.cognitive.spring.spring5startupwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
