package com.lms.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.library.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	
	//query to search for an author by last name and return all of their books written
	@Query(value = "SELECT * FROM book WHERE last_name = ?1 ORDER BY title", nativeQuery = true)
	List<Book> findByAuthor(String lastName);
	
}
