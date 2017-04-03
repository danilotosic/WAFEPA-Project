package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Author;

public interface AuthorService {

	Author findOne(Long authorID);

	Page<Author> findAll(Integer page);
	
	Iterable<Author> findAll();

	Author save(Author author);

	Author delete(Long authorID);

	Page<Author> findByFirstname(String firstname, Integer page);

	Page<Author> findByLastname(String lastname, Integer page);

	Page<Author> findByFirstnameAndLastname(String firstname, String lastname, Integer page);

}
