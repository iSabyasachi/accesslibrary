package com.lms.accesslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.service.UserService;

@RestController
@RequestMapping("/api/lms")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {		
		this.userService = userService;
	}
	
	@PostMapping("/adduser")
    public Response addUser(@RequestBody Request request) {
		
		Response response = userService.addUser(request);

        return response;
    }
	
	@PostMapping("/blockuser")
    public Response blockUser(@RequestBody Request request) {
		
		Response response = userService.blockUser(request);

        return response;
    }
	
	@PostMapping("/unblockuser")
    public Response unBlockUser(@RequestBody Request request) {
		
		Response response = userService.unBlockUser(request);

        return response;
    }

}
