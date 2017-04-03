package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Book;

public interface BookService {

	Book findOne(Long bookID);

	Page<Book> findAll(int page);

	Book save(Book book);

	Book delete(Long bookID);

	Page<Book> findByName(String name, int page);

	Page<Book> findByISBN(String isbn, int page);

}
