package com.lms.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.library.entity.Book;
import com.lms.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return new ResponseEntity<Book>(this.service.create(book), HttpStatus.CREATED);
	}
}
