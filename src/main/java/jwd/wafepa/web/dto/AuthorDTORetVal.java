package jwd.wafepa.web.dto;

import java.util.List;

public class AuthorDTORetVal {

	private Long authorID;
	private String firstname;
	private String lastname;
	private List<BookDTO> books;

	public AuthorDTORetVal() {
		super();
	}

	public AuthorDTORetVal(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public AuthorDTORetVal(String firstname, String lastname, List<BookDTO> books) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.books = books;
	}

	public AuthorDTORetVal(Long authorID, String firstname, String lastname, List<BookDTO> books) {
		super();
		this.authorID = authorID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.books = books;
	}

	public Long getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Long authorID) {
		this.authorID = authorID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

}
