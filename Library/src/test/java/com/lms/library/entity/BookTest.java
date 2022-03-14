package com.lms.library.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import nl.jqno.equalsverifier.EqualsVerifier;

@ActiveProfiles("test")
public class BookTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}
	
	@Test
	public void getAndSetTest() {
		Book book = new Book();
		
		book.setId(1L);
		book.setTitle("The Hobbit");
		book.setLastName("Tolkien");
		book.setFirstName("J.R.R.");
		book.setiSBN("978-0-261102-21-7");
		book.setCategory("FAN");
		
		assertNotNull(book.getId());
		assertNotNull(book.getTitle());
		assertNotNull(book.getLastName());
		assertNotNull(book.getFirstName());
		assertNotNull(book.getiSBN());
		assertNotNull(book.getCategory());
		
		assertEquals(book.getId(), 1L);
		assertEquals(book.getTitle(), "The Hobbit");
		assertEquals(book.getLastName(), "Tolkien");
		assertEquals(book.getFirstName(), "J.R.R.");
		assertEquals(book.getiSBN(), "978-0-261102-21-7");
		assertEquals(book.getCategory(), "FAN");
	}
	
	@Test
	public void allArgsConstructorTest() {
		Book book = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		assertEquals(book.getId(), 1L);
		assertEquals(book.getTitle(), "The Hobbit");
		assertEquals(book.getLastName(), "Tolkien");
		assertEquals(book.getFirstName(), "J.R.R.");
		assertEquals(book.getiSBN(), "978-0-261102-21-7");
		assertEquals(book.getCategory(), "FAN");
	}
	
	@Test
	public void noIdConstructorTest() {
		Book book = new Book("The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		assertEquals(book.getTitle(), "The Hobbit");
		assertEquals(book.getLastName(), "Tolkien");
		assertEquals(book.getFirstName(), "J.R.R.");
		assertEquals(book.getiSBN(), "978-0-261102-21-7");
		assertEquals(book.getCategory(), "FAN");
	}
	
	@Test
	public void toStringTest() {
		Book book = new Book(1, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		assertEquals(book.toString(), "1 The Hobbit Tolkien J.R.R. 978-0-261102-21-7 FAN");
	}
}
