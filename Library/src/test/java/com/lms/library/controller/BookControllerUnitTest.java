package com.lms.library.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.lms.library.entity.Book;
import com.lms.library.service.BookService;

@SpringBootTest
@ActiveProfiles("test")
public class BookControllerUnitTest {
	
	@Autowired
	private BookController controller;
	
	@MockBean
	private BookService service;
	
	@Test
	public void createTest() {
		Book testBook = new Book("The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		Mockito.when(this.service.create(testBook)).thenReturn(testBook);
		
		ResponseEntity<Book> response = new ResponseEntity<Book>(testBook, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.create(testBook));
		
		Mockito.verify(this.service, times(1)).create(testBook);
	}
	
	@Test
	public void readByIdTest() {
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		
		Mockito.when(this.service.readById(1)).thenReturn(testBook);
		
		ResponseEntity<Book> response = new ResponseEntity<Book>(testBook, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readById(1));
		
		Mockito.verify(this.service, times(1)).readById(1);
	}
	
	@Test
	public void readAllTest() {
		List<Book> outputList = new ArrayList<>();
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		outputList.add(testBook);
		
		Mockito.when(this.service.readAll()).thenReturn(outputList);
		
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(outputList, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readAll());
		
		Mockito.verify(this.service, times(1)).readAll();
	}
	
	@Test
	public void updateTest() {
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		Book updateBook = new Book(1L, "The Hobbit", "Tolkien", "John", "978-0-261102-21-7", "FAN");
		
		Mockito.when(this.service.update(1L, testBook)).thenReturn(updateBook);
		
		ResponseEntity<Book> response = new ResponseEntity<Book>(updateBook, HttpStatus.ACCEPTED);
		
		assertThat(response).isEqualTo(this.controller.update(1L, testBook));
		
		Mockito.verify(this.service, times(1)).update(1L, testBook);
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(this.service.delete(1L)).thenReturn(false);
		
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
		
		assertThat(response).isEqualTo(this.controller.delete(1L));
		
		Mockito.verify(this.service, times(1)).delete(1L);
	}
	
	@Test
	public void findByAuthorTest() {
		List<Book> outputList = new ArrayList<>();
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		outputList.add(testBook);
		
		Mockito.when(this.service.findByAuthor("Tolkien")).thenReturn(outputList);
		
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(outputList, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.findByAuthor("Tolkien"));
		
		Mockito.verify(this.service, times(1)).findByAuthor("Tolkien");
	}
	
	@Test
	public void findByCategoryTest() {
		List<Book> outputList = new ArrayList<>();
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		outputList.add(testBook);
		
		Mockito.when(this.service.findByCategory("FAN")).thenReturn(outputList);
		
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(outputList, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.findByCategory("FAN"));
		
		Mockito.verify(this.service, times(1)).findByCategory("FAN");
	}
	
	@Test
	public void countByIsbnTest() {
		List<Book> outputList = new ArrayList<>();
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		outputList.add(testBook);
		
		Mockito.when(this.service.countByIsbn("978-0-261102-21-7")).thenReturn(1L);
		
		ResponseEntity<Long> response = new ResponseEntity<Long>(1L, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.countByIsbn("978-0-261102-21-7"));
		
		Mockito.verify(this.service, times(1)).countByIsbn("978-0-261102-21-7");
	}
	
	@Test
	public void countTest() {
		List<Book> outputList = new ArrayList<>();
		Book testBook = new Book(1L, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		outputList.add(testBook);
		
		Mockito.when(this.service.count()).thenReturn(1L);
		
		ResponseEntity<Long> response = new ResponseEntity<Long>(1L, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.count());
		
		Mockito.verify(this.service, times(1)).count();
	}
}
