package com.lms.accesslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Checkout;
import com.lms.accesslibrary.dto.CheckoutResponse;
import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.service.BookService;

@RestController
@RequestMapping("/api/lms")
public class BookController {
	@Autowired
	private BookService bookService;

	public BookController(BookService bookService) {		
		this.bookService = bookService;
	}
	
	@PostMapping("/addbook")
    public Response addBook(@RequestBody Request request) {
		
		Response response = bookService.addBook(request);

        return response;
    }
	
	@PostMapping("/removebook")
    public Response removeBook(@RequestBody Request request) {
		
		Response response = bookService.removeBook(request);

        return response;
    }
	
}
