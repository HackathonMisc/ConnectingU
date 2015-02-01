package com.example.connectingu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class UserPref extends Activity {
	private ArrayList<String> stringArray;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_pref);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_pref, menu);
		return true;
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
	public void saveToFile(View view){
		
	
		String FILENAME = "userName"; // save user name
		String FILENAME2 = "email"; // save email
		String FILENAME3 = "deletion"; // save deletion code
		
		
		
		EditText userEmailName = (EditText) findViewById(R.id.emailLine);
		String userEmail = userEmailName.getText().toString();
		
	
		EditText userName = (EditText) findViewById(R.id.uName);
		String uName = userName.getText().toString();
		
		EditText deletionCode = (EditText) findViewById(R.id.deletionCode);
		String deleteCode = deletionCode.getText().toString();

		FileOutputStream fos = null;

		FileOutputStream fos2 = null;

		FileOutputStream fos3 = null;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos2 = openFileOutput(FILENAME2, Context.MODE_PRIVATE);
			fos3 = openFileOutput(FILENAME3, Context.MODE_PRIVATE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.write(userEmail.getBytes());
			fos2.write(uName.getBytes());
			fos3.write(deleteCode.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
			fos2.close();
			fos3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
		
	}
	public void cancel(View view){
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
