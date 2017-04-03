package jwd.wafepa.web.dto;

public class BookDTORetVal {

	private Long bookID;
	private String isbn;
	private String name;
	private AuthorDTO author;

	public BookDTORetVal() {
		super();
	}

	public BookDTORetVal(String isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}

	public BookDTORetVal(String isbn, String name, AuthorDTO author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}

	public BookDTORetVal(Long bookID, String isbn, String name, AuthorDTO author) {
		super();
		this.bookID = bookID;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
