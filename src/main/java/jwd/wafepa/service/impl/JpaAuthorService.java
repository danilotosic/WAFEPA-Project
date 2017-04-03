package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Author;
import jwd.wafepa.repository.AuthorRepository;
import jwd.wafepa.service.AuthorService;

@Service
@Transactional
public class JpaAuthorService implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author findOne(Long authorID) {
		return authorRepository.findOne(authorID);
	}

	@Override
	public Page<Author> findAll(Integer page) {
		return authorRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author delete(Long authorID) {
		Author retVal = authorRepository.findOne(authorID);
		authorRepository.delete(authorID);
		return retVal;
	}

	@Override
	public Page<Author> findByFirstname(String firstname, Integer page) {
		return authorRepository.findByFirstnameContains(firstname, new PageRequest(page, 10));
	}

	@Override
	public Page<Author> findByLastname(String lastname, Integer page) {
		return authorRepository.findByLastnameContains(lastname, new PageRequest(page, 10));
	}

	@Override
	public Page<Author> findByFirstnameAndLastname(String firstname, String lastname, Integer page) {
		return authorRepository.findByFirstnameContainsAndLastnameContains(firstname, lastname,
				new PageRequest(page, 10));
	}

	@Override
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

}
