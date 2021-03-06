package com.lms.accesslibrary.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.accesslibrary.bo.BookBO;
import com.lms.accesslibrary.bo.UserBO;
import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.entity.library.book.Book;
import com.lms.accesslibrary.entity.library.user.User;
import com.lms.accesslibrary.enums.UserType;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private Response response;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private BookBO bookBO;

	@Override
	public Response addBook(Request request) {
		
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(request.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		Book book = request.getBook();
		//book.setPublicationDate(DateFormatUtility.convertStringToDate(book.getPublicationDate()));
		book.setCreatedTS(Timestamp.from(Instant.now()));
		book.setUpdatedTS(Timestamp.from(Instant.now()));
		bookBO.save(request.getBook());	
		
		response.setMessage("You have successfully added the book with ISBN : "+request.getBook().getISBN());	
		return response;
	}

	@Override
	public Response removeBook(Request request) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(request.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		Book book = bookBO.findBybarcode(request.getBook().getBarcode());
		
		if(book == null) {
			response.setMessage("FAILED!!! Book is not found.");
			return response;
		}
		
		bookBO.delete(book);	
		
		response.setMessage("You have successfully deleted the book with Bar Code : "+request.getBook().getBarcode());	
		return response;
		
	}
	
}
