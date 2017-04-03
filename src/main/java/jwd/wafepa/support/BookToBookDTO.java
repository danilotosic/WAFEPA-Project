package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTO;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO> {

	@Override
	public BookDTO convert(Book book) {
		BookDTO dtoBook = new BookDTO();

		dtoBook.setBookID(book.getBookID());
		dtoBook.setIsbn(book.getIsbn());
		dtoBook.setName(book.getName());

		return dtoBook;
	}

	public List<BookDTO> convert(List<Book> books) {
		List<BookDTO> dtoBooks = new ArrayList<>();
		for (Book book : books) {
			dtoBooks.add(convert(book));
		}
		return dtoBooks;
	}

}
