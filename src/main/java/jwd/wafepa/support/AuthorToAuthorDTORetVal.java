package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;
import jwd.wafepa.web.dto.AuthorDTORetVal;

@Component
public class AuthorToAuthorDTORetVal implements Converter<Author, AuthorDTORetVal> {

	private BookToBookDTO toBookDTO = new BookToBookDTO();

	@Override
	public AuthorDTORetVal convert(Author author) {
		AuthorDTORetVal retVal = new AuthorDTORetVal();

		retVal.setAuthorID(author.getAuthorID());
		retVal.setFirstname(author.getFirstname());
		retVal.setLastname(author.getLastname());
		retVal.setBooks(toBookDTO.convert(author.getBooks()));

		return retVal;
	}

	public List<AuthorDTORetVal> convert(List<Author> authors) {
		List<AuthorDTORetVal> retVals = new ArrayList<>();
		for (Author author : authors) {
			retVals.add(convert(author));
		}
		return retVals;
	}

}
