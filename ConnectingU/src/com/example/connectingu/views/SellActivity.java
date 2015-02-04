package com.example.connectingu.views;

import com.example.connectingu.R;
import com.example.connectingu.Models.bookList;
import com.example.connectingu.Models.textBookModel;
import com.example.connectingu.R.id;
import com.example.connectingu.R.layout;
import com.example.connectingu.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SellActivity extends Activity {
	public static final String PREFS_NAME = "MyPrefsFile";
	textBookModel newBook;
	bookList books;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		books = bookList.getInstance();
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
	public void publishBook(View view){
		
		EditText Decsrip = (EditText) findViewById(R.id.bookDescription);
		String Description = Decsrip.getText().toString();
		
	
		EditText CId = (EditText) findViewById(R.id.courseId);
		String courseID = CId.getText().toString();
		
		EditText name = (EditText) findViewById(R.id.textBookName);
		String names = name.getText().toString();
		

		EditText pr = (EditText) findViewById(R.id.Price);
		String price = pr.getText().toString();
		
		newBook = new textBookModel(names, price, Description,courseID);
		getSharedPrefs();
		books.add(newBook);
		Toast.makeText(this,"your book has been added", Toast.LENGTH_LONG).show();
		
		
		
	}
	private void getSharedPrefs(){
		SharedPreferences myPrefs = getSharedPreferences( PREFS_NAME, MODE_PRIVATE);
		newBook.setSellerDeletionCode(myPrefs.getString("delCode", ""));
		newBook.setSellerEmail(myPrefs.getString("Email", "No Email Provided"));
		newBook.setSellerName(myPrefs.getString("uName", "John Doe"));
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void mainMenu(View view){
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
