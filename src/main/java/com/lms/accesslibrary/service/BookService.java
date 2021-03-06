package com.lms.accesslibrary.service;

import org.springframework.stereotype.Service;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;

@Service
public interface BookService {
	public Response addBook(Request request);
	public Response removeBook(Request request);	
}
