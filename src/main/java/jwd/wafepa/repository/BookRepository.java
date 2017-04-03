package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	Page<Book> findByNameContains(String name, Pageable page);

	Page<Book> findByIsbnContains(String isbn, Pageable page);

}
