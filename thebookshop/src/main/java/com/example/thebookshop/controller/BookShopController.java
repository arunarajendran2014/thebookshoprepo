package com.example.thebookshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thebookshop.model.Books;
import com.example.thebookshop.model.BooksList;
import com.example.thebookshop.service.BookShopService;
import com.example.thebookshop.util.CartSummary;

@RestController
public class BookShopController {
	
	private BookShopService bookShopService;
	private BooksList bookList;
	
	@Autowired
	public BookShopController(BookShopService bookShopService, BooksList bookList) {
		super();
		this.bookShopService = bookShopService;
		this.bookList = bookList;
	}

	
	@GetMapping("/books")
	public List<Books> getBookList(@RequestParam(value = "id", defaultValue = "") String id){
		return bookList.getBookList();		
	}
	
	@PostMapping(value = "/updateCart", consumes = "application/json", produces = "application/json")
	public double cartValue(@RequestBody @Valid List<Books> request) {
		return bookShopService.calculateCartValue(request);
		
	}

}
