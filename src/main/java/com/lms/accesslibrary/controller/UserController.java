package com.lms.accesslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.entity.library.user.User;
import com.lms.accesslibrary.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {		
		this.userService = userService;
	}
	
	@GetMapping("/read/one")
	public String readUser() {
		User user = new User();
		user.setName("Sabyasach");
		return user.toString();
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
