package com.example.connectingu.Models;

import android.content.SharedPreferences;

public class textBookModel {
	private String textBookName;
	private String Cid;
	private String price;
	private String comments;
	private String sellerName;
	private String sellerEmail;
	private String sellerDeletionCode;
	private String StringPREFS_NAME = "MyPrefsFile";
	public textBookModel(String bookName,String bookPrice, String comment,String CId){
		textBookName = bookName;
		price = bookPrice;
		comments= comment;
		Cid=CId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerDeletionCode() {
		return sellerDeletionCode;
	}
	public void setSellerDeletionCode(String sellerDeletionCode) {
		this.sellerDeletionCode = sellerDeletionCode;
	}	
	
	
}
