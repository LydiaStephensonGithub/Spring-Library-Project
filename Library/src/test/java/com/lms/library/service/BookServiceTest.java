package com.lms.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.lms.library.entity.Book;
import com.lms.library.repo.BookRepo;

@ActiveProfiles("test")
@SpringBootTest
public class BookServiceTest {

	@Autowired
	private BookService service;
	
	@MockBean
	private BookRepo repo;
	
	@Test
	public void createTest() {
		Book input = new Book("The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		Book output = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
}
