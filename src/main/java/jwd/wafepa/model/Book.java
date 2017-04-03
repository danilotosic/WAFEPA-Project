package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblBook")
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "bookID")
	private Long bookID;

	@Column(name = "name")
	private String name;

	@Column(name = "isbn")
	private String isbn;

	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;

	public Book() {
		super();
	}

	public Book(String name) {
		super();
		this.name = name;
	}

	public Book(String name, String isbn) {
		super();
		this.name = name;
		this.isbn = isbn;
	}

	public Book(Long bookID, String name, String isbn) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.isbn = isbn;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
		if (author != null && !author.getBooks().contains(this)) {
			author.getBooks().add(this);
		}
	}

}
