package com.lms.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<Book> readById(@PathVariable long id) {
		return new ResponseEntity<Book>(this.service.readById(id), HttpStatus.OK);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Book>> readAll() {
		return new ResponseEntity<List<Book>>(this.service.readAll(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> update(@PathVariable long id, @RequestBody Book book) {
		return new ResponseEntity<Book>(this.service.update(id, book), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/findByAuthor/{lastName}")
	public ResponseEntity<List<Book>> findByAuthor(@PathVariable String lastName) {
		return new ResponseEntity<List<Book>>(this.service.findByAuthor(lastName), HttpStatus.OK);
	}
}
