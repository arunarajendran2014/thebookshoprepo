package com.example.thebookshop.util;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.thebookshop.model.Books;
public class CartSummary {
	
	
	 private int bookPrice = 50;
	 
		public double calculateDifferentFiveBooks(List<Books> request) {
			
			double discountPrice = 0.0;
			double price = 0;
			int discountPercent = 25;
			int count = 0;
			Map<Integer, Integer> bookMap = new HashMap<>();
			for(Books book: request) {
				if(!bookMap.containsKey(book.getBookId())) {
					bookMap.put(book.getBookId(), 1);
				} else {
					bookMap.put(book.getBookId(), bookMap.get(book.getBookId()) + 1);
				}				
			}
			checkDiscount(bookMap);
			discountPrice = price - price * discountPercent/100; 
			return discountPrice; 
		}

		private Map<String, Integer> checkDiscount(Map<Integer, Integer> bookMap) {
			
			Map<String, Integer> discountMap = new HashMap<>();
			discountMap.put("TWENTYFIVE", 0);
			discountMap.put("TWENTY", 0);
			discountMap.put("TEN", 0);
			discountMap.put("NODISCOUNT", 0);
			int count = 0;
			int noDiscountBook = 0;
			for(Entry<Integer, Integer> map : bookMap.entrySet()) {
        		count = count + map.getValue();
        	}
			
			switch (bookMap.size()) {
            case 3:
            	for(Entry<Integer, Integer> map : bookMap.entrySet()) {
            		count = count + map.getValue();
            	}
            	discountMap.replace("TEN", 1);
            	discountMap.replace("NODISCOUNT", count-bookMap.size() < 3 ? count-bookMap.size() : updateNoDiscount(bookMap));
                break;
            case 4:
            	discountMap.replace("TWENTY", 1);
            	discountMap.replace("NODISCOUNT", count-bookMap.size() < 3 ? count-bookMap.size() : updateNoDiscount(bookMap));
                break;
            case 5:
            	discountMap.put("TWENTYFIVE", 1);
            	discountMap.replace("NODISCOUNT", count-bookMap.size() < 3 ? count-bookMap.size() : updateNoDiscount(bookMap));
                break;
            default:
                break;
			}
			return discountMap;
		}

		private int updateNoDiscount(Map<Integer, Integer> bookMap) {
			int count = 0;
			int noDiscountBook = 0;
			for(Entry<Integer, Integer> map : bookMap.entrySet()) {
        		count = count + map.getValue();
        	}
			
			switch (bookMap.size()) {
            case 3:
            	noDiscountBook = 1;
                break;
            case 4:
            	noDiscountBook = 2;
                break;
            case 5:
                break;
            default:
                break;
			}
		
			return noDiscountBook;
		}

		

}
