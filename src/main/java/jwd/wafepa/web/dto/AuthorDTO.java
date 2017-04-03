package jwd.wafepa.web.dto;

public class AuthorDTO {

	private Long authorID;
	private String firstname;
	private String lastname;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public AuthorDTO(Long authorID, String firstname, String lastname) {
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

}
