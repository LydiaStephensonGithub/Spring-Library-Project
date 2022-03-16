package com.lms.library.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library.entity.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:book-schema.sql", "classpath:book-data.sql"})

public class BookControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		Book testBook = new Book("The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		String testBookAsJson = this.mapper.writeValueAsString(testBook);
		
		RequestBuilder req = post("/book/create").content(testBookAsJson).contentType(MediaType.APPLICATION_JSON);
		
		Book testSavedBook = new Book(2, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		String testSavedBookAsJson = this.mapper.writeValueAsString(testSavedBook);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedBookAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/book/readById/1");
		
		Book testBook = new Book(1, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		String testBookAsJson = this.mapper.writeValueAsString(testBook);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testReadAll() throws Exception {
		RequestBuilder req = get("/book/readAll");
		
		List<Book> testList = new ArrayList<>();
		Book testBook = new Book(1, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		testList.add(testBook);
		String testListAsJson = this.mapper.writeValueAsString(testList);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testListAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Book testBook = new Book(1, "The Hobbit", "Tolkien", "John", "978-0-261102-21-7", "FAN");
		String testBookAsJson = this.mapper.writeValueAsString(testBook);
		
		RequestBuilder req = put("/book/update/1").content(testBookAsJson).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testBookAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testDelete() throws Exception {
		RequestBuilder req = delete("/book/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
	}
	
	@Test
	public void testFindByAuthor() throws Exception {
		RequestBuilder req = get("/book/findByAuthor/Tolkien");
		
		List<Book> testList = new ArrayList<>();
		Book testBook = new Book(1, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		testList.add(testBook);
		String testListAsJson = this.mapper.writeValueAsString(testList);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testListAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testFindByCategory() throws Exception {
		RequestBuilder req = get("/book/findByCategory/FAN");
		
		List<Book> testList = new ArrayList<>();
		Book testBook = new Book(1, "The Hobbit", "Tolkien", "J.R.R.", "978-0-261102-21-7", "FAN");
		testList.add(testBook);
		String testListAsJson = this.mapper.writeValueAsString(testList);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testListAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testCountByIsbn() throws Exception {
		RequestBuilder req = get("/book/countByIsbn/978-0-261102-21-7");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json("1");
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testCount() throws Exception {
		RequestBuilder req = get("/book/count");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json("1");
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
}
