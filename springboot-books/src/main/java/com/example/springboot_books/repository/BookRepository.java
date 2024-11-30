package com.example.springboot_books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_books.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
