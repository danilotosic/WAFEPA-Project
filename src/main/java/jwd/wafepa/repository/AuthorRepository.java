package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import jwd.wafepa.model.Author;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

	Page<Author> findByFirstnameContains(String firstname, Pageable page);

	Page<Author> findByLastnameContains(String lastname, Pageable page);

	Page<Author> findByFirstnameContainsAndLastnameContains(String firstname, String lastname, Pageable page);

}
