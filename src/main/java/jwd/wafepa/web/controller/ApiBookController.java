package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Book;
import jwd.wafepa.service.BookService;
import jwd.wafepa.support.BookToBookDTORetVal;
import jwd.wafepa.web.dto.BookDTORetVal;

@RestController
@RequestMapping(value = "/api/books")
public class ApiBookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookToBookDTORetVal toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookDTORetVal>> getBooks(@RequestParam(defaultValue = "0") int page,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "isbn", required = false) String isbn) {

		Page<Book> books;

		if (name != null) {
			books = bookService.findByName(name, page);
		} else if (isbn != null) {
			books = bookService.findByISBN(isbn, page);
		} else {
			books = bookService.findAll(page);
		}

		List<Book> retVal = books.getContent();
		int totalPages = books.getTotalPages();

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", totalPages + "");

		return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookDTORetVal> getBook(@PathVariable Long id) {

		Book book = bookService.findOne(id);

		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(book), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTORetVal> post(@RequestBody Book book) {

		Book retVal = bookService.save(book);

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<BookDTORetVal> put(@RequestBody Book book, @PathVariable Long id) {

		if (id == null || !id.equals(book.getBookID())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Book persisted = bookService.save(book);

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<BookDTORetVal> delete(@PathVariable Long id) {

		bookService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
