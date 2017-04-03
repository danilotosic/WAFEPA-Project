package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblAuthor")
public class Author {

	@Id
	@GeneratedValue
	@Column(name = "authorID")
	private Long authorID;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
	private List<Book> books = new ArrayList<>();

	public Author() {
		super();
	}

	public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Author(Long authorID, String firstname, String lastname) {
		super();
		this.authorID = authorID;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
		if (book.getAuthor() != this) {
			book.setAuthor(this);
		}
	}

}
