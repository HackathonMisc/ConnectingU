package com.example.connectingu.Data;


import java.util.List;

import android.content.Context;

import com.example.connectingu.Models.textBookModel;

public class dataController {
	public FileDataManager myDataManager;
	private List<textBookModel> loadList; 
	
	
	public dataController(){
		myDataManager = FileDataManager.getInstance();
	}
	
	public void saveData(List<textBookModel> textbooks, String file){
		myDataManager.saveToDos(textbooks, file);
		
	}
	public List<textBookModel> loadData(String file){
		loadList = myDataManager.loadToDo(file);
		return loadList;
		// should just update singleton
		
	}
	public void setContext(Context context2){
		myDataManager = FileDataManager.getInstance();
		myDataManager.createContext(context2);
	}
	
}

