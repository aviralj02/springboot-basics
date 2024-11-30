package com.example.springboot_books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_books.entity.Book;
import com.example.springboot_books.repository.BookRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping
	@ResponseBody
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Book getBookById(@PathVariable int id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isEmpty()) {
			throw new RuntimeException("Id not found");
		} else {
			return book.get();
		}
	}
	
	@PostMapping
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Book updateBook(@RequestBody Book book, @PathVariable int id) {
		if (bookRepo.existsById(id)) {
			Book dbBook = getBookById(id);
			
			if (book.getTitle() != null) {
				dbBook.setTitle(book.getTitle());
			}
			if (book.getAuthor() != null) {
				dbBook.setAuthor(book.getAuthor());
			}
			if (book.getCategory() != null) {
				dbBook.setCategory(book.getCategory());
			}
			if (book.getPrice() > 0) {
				dbBook.setPrice(book.getPrice());
			}
			
			return bookRepo.save(dbBook);
		} else {
			throw new RuntimeException("Id not found");			
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Book deleteBook(@PathVariable int id) {
		if (bookRepo.existsById(id)) {
			Book dbBook = getBookById(id);
			bookRepo.deleteById(id);
			
			return dbBook;
		}
		else {
			throw new RuntimeException("Id not found");
		}
	}
}
