package jwd.wafepa.web.dto;

public class BookDTO {

	private Long bookID;
	private String isbn;
	private String name;

	public BookDTO() {
		super();
	}

	public BookDTO(String isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}

	public BookDTO(Long bookID, String isbn, String name) {
		super();
		this.bookID = bookID;
		this.isbn = isbn;
		this.name = name;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
