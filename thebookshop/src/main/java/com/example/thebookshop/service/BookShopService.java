package com.example.thebookshop.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.thebookshop.model.Books;
import com.example.thebookshop.util.CartSummary;


@Service
public class BookShopService {	
	
   public int bookPrice = 50;
	public CartSummary calculateCartValue(List<Books> request) {
		
		double totalPrice = 0.0;
		
		return new CartSummary();
	}

	

	
	
	
	
	
	
	
	

}
