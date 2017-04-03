package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Book;
import jwd.wafepa.repository.BookRepository;
import jwd.wafepa.service.BookService;

@Service
@Transactional
public class JpaBookService implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findOne(Long bookID) {
		return bookRepository.findOne(bookID);
	}

	@Override
	public Page<Book> findAll(int page) {
		return bookRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book delete(Long bookID) {
		Book retVal = bookRepository.findOne(bookID);
		bookRepository.delete(bookID);
		return retVal;
	}

	@Override
	public Page<Book> findByName(String name, int page) {
		return bookRepository.findByNameContains(name, new PageRequest(page, 10));
	}

	@Override
	public Page<Book> findByISBN(String isbn, int page) {
		return bookRepository.findByIsbnContains(isbn, new PageRequest(page, 10));
	}

}
