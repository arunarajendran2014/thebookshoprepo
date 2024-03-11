package com.example.thebookshop.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Books {
	
	@NotBlank
	@Max(5)
    @Min(1)
    @NotNull
	private int bookId;
	
	@NotBlank
	private String bookName;
	
	@NotBlank
	private int bookPrice;
	
	@NotBlank
	@Min(1)
	private int bookQuantity;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
	
	
	

}
