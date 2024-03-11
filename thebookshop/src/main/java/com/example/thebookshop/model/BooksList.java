package com.example.thebookshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BooksList {
	
	private List<Books> bookList;	
	

	public BooksList() {
		super();
		this.bookList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "BooksList [bookList=" + bookList + "]";
	}

	public List<Books> getBookList() {
		return bookList;
	}

	public void setBookList(List<Books> bookList) {
		this.bookList = bookList;
	}
	

}
