package com.example.thebookshop.util;


import java.util.Collections;
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
			
			List<Integer> list = (List<Integer>) bookMap.values();
			Collections.sort(list);
			int noDiscountBook = 0;
			switch (bookMap.size()) {
	        case 3:
	        	discountMap.replace("TEN", list.get(0));
	        	noDiscountBook = list.get(list.size() - 4)+list.get(list.size() - 3);
	        	discountMap.replace("NODISCOUNT",noDiscountBook);
	            break;
	        case 4:
	        	discountMap.replace("TWENTY", list.get(0));
	        	discountMap.replace("TEN", list.get(1) - list.get(0));
	        	noDiscountBook = discountMap.get("TEN") != 0 ? list.get(list.size() - 1)-list.get(list.size() - 2)  
	        		: list.get(list.size() - 4) + list.get(list.size() - 3);
	        	discountMap.replace("NODISCOUNT",noDiscountBook);
	            break;
	        case 5:
	        	discountMap.put("TWENTYFIVE", list.get(0));
	        	discountMap.replace("TWENTY", list.get(1) - list.get(0));
	        	discountMap.replace("TEN", list.get(2) - list.get(1));
				noDiscountBook = discountMap.get("TWENTY") != 0 && discountMap.get("TEN") != 0
						? list.get(list.size() - 1) - list.get(list.size() - 2)
						: (discountMap.get("TWENTY") == 0 && discountMap.get("TEN") != 0)
								|| (discountMap.get("TWENTY") != 0 && discountMap.get("TEN") == 0)
										? list.get(list.size() - 1) - list.get(list.size() - 2)
										: list.get(list.size() - 5) + list.get(list.size() - 4) + list.get(list.size() - 3);
	        	discountMap.replace("NODISCOUNT",noDiscountBook);
	            break;
	        default:
	        	for(int i = 0; i < list.size(); i++) {
	        		noDiscountBook = noDiscountBook + list.get(i);
	        	}
	        	discountMap.replace("NODISCOUNT",noDiscountBook);
	            break;
			}
			return discountMap;
		}
}
