package com.example.thebookshop.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.thebookshop.model.Books;
import com.example.thebookshop.util.CartSummary;


@Service
public class BookShopService {	
	
  
	public double calculateCartValue(List<Books> request) {
		return new CartSummary().calculateDifferentFiveBooks(request);
	}

	

	
	
	
	
	
	
	
	

}
