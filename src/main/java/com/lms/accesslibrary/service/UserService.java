package com.lms.accesslibrary.service;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;

public interface UserService {	
	public Response addUser(Request request);
	public Response blockUser(Request request);
	public Response unBlockUser(Request request);
}
