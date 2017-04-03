package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTORetVal;

@Component
public class BookToBookDTORetVal implements Converter<Book, BookDTORetVal> {

	private AuthorToAuthorDTO toAuthorDTO = new AuthorToAuthorDTO();

	@Override
	public BookDTORetVal convert(Book book) {
		BookDTORetVal retVal = new BookDTORetVal();

		retVal.setBookID(book.getBookID());
		retVal.setIsbn(book.getIsbn());
		retVal.setName(book.getName());
		retVal.setAuthor(toAuthorDTO.convert(book.getAuthor()));

		return retVal;
	}

	public List<BookDTORetVal> convert(List<Book> books) {
		List<BookDTORetVal> retVals = new ArrayList<>();
		for (Book book : books) {
			retVals.add(convert(book));
		}
		return retVals;
	}

}
