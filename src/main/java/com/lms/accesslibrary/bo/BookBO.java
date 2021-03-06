package com.lms.accesslibrary.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.accesslibrary.dao.BookRepository;
import com.lms.accesslibrary.entity.library.book.Book;

@Component
public class BookBO {
	
	@Autowired
	BookRepository bookRepository;
	
	public Book findByISBN(String isbn) {
		return bookRepository.findByISBN(isbn);
	};
	
	public Book findBybarcode(String barcode) {
		return bookRepository.findBybarcode(barcode);
	};

	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	
}
