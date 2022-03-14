package com.lms.library.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
	@Column(length = 17)
	@Size(min = 13, max = 17)
	private String iSBN;
	
	@Column(nullable = false, length = 3)
	@Size(min = 3, max = 3)
	private String category;
	
	//default constructor
	public Book() {}

	//all arguments constructor
	public Book(long id, String title, String lastName, String firstName, @Size(min = 13, max = 17) String iSBN,
			@Size(min = 3, max = 3) String category) {
		this.id = id;
		this.title = title;
		this.lastName = lastName;
		this.firstName = firstName;
		this.iSBN = iSBN;
		this.category = category;
	}

	//no id constructor
	public Book(String title, String lastName, String firstName, @Size(min = 13, max = 17) String iSBN,
			@Size(min = 3, max = 3) String category) {
		this.title = title;
		this.lastName = lastName;
		this.firstName = firstName;
		this.iSBN = iSBN;
		this.category = category;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, firstName, iSBN, lastName, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(category, other.category) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(iSBN, other.iSBN) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return id + " " + title + " " + lastName + " " + firstName + " " + iSBN + " " + category;
	}	
}
