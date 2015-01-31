package com.example.connectingu;

public class textBookModel {
	private String textBookName;
	private String Seller;
	private String price;
	private String comments;
	public textBookModel(String bookName,String bookPrice, String comment){
		textBookName = bookName;
		price = bookPrice;
		comments= comment;
		loadUserPref();
	}
	private void loadUserPref(){
		
	}
}
