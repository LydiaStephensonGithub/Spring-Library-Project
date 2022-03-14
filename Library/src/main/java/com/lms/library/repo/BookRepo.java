package com.lms.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.library.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
