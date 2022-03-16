package com.lms.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.library.entity.Book;
import com.lms.library.exceptions.BookNotFoundException;
import com.lms.library.repo.BookRepo;

@Service
public class BookService implements ServiceMethods<Book> {
	
	private BookRepo repo;
	
	public BookService(BookRepo repo) {
		this.repo = repo;
	}

	@Override
	public Book create(Book t) {
		return this.repo.save(t);
	}

	@Override
	public Book readById(long id) {
		Book found = this.repo.findById(id).orElseThrow(BookNotFoundException::new);
		return found;
	}

	@Override
	public List<Book> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Book update(long id, Book t) {
		Book found = this.repo.findById(id).orElseThrow(BookNotFoundException::new);
		found.setTitle(t.getTitle());
		found.setFirstName(t.getFirstName());
		found.setLastName(t.getLastName());
		found.setiSBN(t.getiSBN());
		found.setCategory(t.getCategory());
		return this.repo.saveAndFlush(found);
	}

	@Override
	public Boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	public List<Book> findByAuthor(String lastName) {
		return this.repo.findByAuthor(lastName);
	}
	
	public List<Book> findByCategory(String category) {
		return this.repo.findByCategory(category);
	}
	
	public Long countByIsbn(String iSBN) {
		return this.repo.countByiSBN(iSBN);
	}
	
	public long count() {
		return this.repo.count();
	}
}
