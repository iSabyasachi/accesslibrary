package com.lms.accesslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Checkout;
import com.lms.accesslibrary.dto.CheckoutResponse;
import com.lms.accesslibrary.service.CheckoutService;

@RestController
@RequestMapping("/api/lms")
public class CheckoutController {
	@Autowired
	private CheckoutService checkoutService;

	public CheckoutController(CheckoutService checkoutService) {		
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/checkout")
    public CheckoutResponse checkoutBook(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.checkoutBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/return")
    public CheckoutResponse returnBook(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.returnBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/renew")
    public CheckoutResponse renewBook(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.renewBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/reserve")
    public CheckoutResponse reserveBook(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.reserveBook(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/payfine")
    public CheckoutResponse payFine(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.payFine(checkout);

        return checkoutResponse;
    }
	
	@GetMapping("/getfine")
    public CheckoutResponse getFine(@RequestBody Checkout checkout) {
		
		CheckoutResponse checkoutResponse = checkoutService.getFine(checkout);

        return checkoutResponse;
    }
}
