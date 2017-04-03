package jwd.wafepa.web.controller;

import java.util.ArrayList;
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

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.support.AuthorToAuthorDTORetVal;
import jwd.wafepa.web.dto.AuthorDTORetVal;

@RestController
@RequestMapping(value = "/api/authors")
public class ApiAutorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorToAuthorDTORetVal toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AuthorDTORetVal>> getAuthors(
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "lastname", required = false) String lastname,
			@RequestParam(value = "page", required = false) Integer page) {

		List<Author> retVal = new ArrayList<>();
		int totalPages = -1;

		if (page == null) {

			Iterable<Author> iterableAuthors;
			iterableAuthors = authorService.findAll();

			for (Author author : iterableAuthors) {
				retVal.add(author);
			}

		} else {

			Page<Author> authors;

			if (firstname != null && lastname != null) {
				authors = authorService.findByFirstnameAndLastname(firstname, lastname, page);
			} else if (firstname != null) {
				authors = authorService.findByFirstname(firstname, page);
			} else if (lastname != null) {
				authors = authorService.findByLastname(lastname, page);
			} else {
				authors = authorService.findAll(page);
			}

			retVal = authors.getContent();
			totalPages = authors.getTotalPages();
		}


		if (retVal.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		HttpHeaders headers = new HttpHeaders();
		
		if(totalPages >= 0) {
			headers.add("totalPages", totalPages + "");
		}

		return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuthorDTORetVal> getAuthor(@PathVariable Long id) {

		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Author author = authorService.findOne(id);

		if (author == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(author), HttpStatus.OK);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<AuthorDTORetVal> post(@RequestBody Author author) {

		if (author == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Author retVal = authorService.save(author);

		if (author.getBooks() != null) {
			for (Book b : author.getBooks()) {
				b.setAuthor(author);
				b.setBookID(null);
				bookService.save(b);
			}
		}

		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", consumes = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<AuthorDTORetVal> put(@RequestBody Author author, @PathVariable Long id) {

		if (id == null || !id.equals(author.getAuthorID())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Author retVal = authorService.save(author);

		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AuthorDTORetVal> delete(@PathVariable Long id) {

		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Author retVal = authorService.delete(id);

		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

}
