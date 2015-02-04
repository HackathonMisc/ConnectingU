package com.example.connectingu.Models;

import java.util.ArrayList;
import java.util.List;

import com.example.connectingu.Data.dataController;

public class bookList {
		//array of ToDoItems
		private List<textBookModel> books = new ArrayList<textBookModel>();
		private static bookList firstInstance = null;
		private dataController data = new dataController();
		public bookList() {	};
		private final static String file = "books";// unarchived save file

		//singleton design principle 
		public static bookList getInstance(){
			if(firstInstance == null){
				synchronized(bookList.class){
					if(firstInstance == null){
						firstInstance = new bookList();
					}
				}
			}
			return firstInstance;
		}
		
		
		public textBookModel getToDoItem(int x){
			return firstInstance.books.get(x);
		}
		
		public List<textBookModel> getToDoList(){
			books= data.loadData(file);
			return books;
		}
		
		public void add(textBookModel y){
			firstInstance.books.add(0,y);
			save();
		}
		
		public void remove(textBookModel z){
			firstInstance.books.remove(z);
			save();
		}
		
		public int size(){
			return firstInstance.books.size();
		}
		public void deleteAll(){
			firstInstance.books.clear();
			save();
		}
		
		public void save() {
				data.saveData(books, file);
	   }
		
	}
