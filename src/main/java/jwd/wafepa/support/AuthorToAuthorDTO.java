package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;
import jwd.wafepa.web.dto.AuthorDTO;

@Component
public class AuthorToAuthorDTO implements Converter<Author, AuthorDTO> {

	@Override
	public AuthorDTO convert(Author author) {
		AuthorDTO dtoAuthor = new AuthorDTO();

		dtoAuthor.setAuthorID(author.getAuthorID());
		dtoAuthor.setFirstname(author.getFirstname());
		dtoAuthor.setLastname(author.getLastname());

		return dtoAuthor;
	}

	public List<AuthorDTO> convert(List<Author> authors) {
		List<AuthorDTO> dtoAuthors = new ArrayList<>();
		for (Author author : authors) {
			dtoAuthors.add(convert(author));
		}
		return dtoAuthors;
	}

}
