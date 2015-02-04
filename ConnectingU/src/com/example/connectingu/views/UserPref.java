package com.example.connectingu.views;

import com.example.connectingu.R;
import com.example.connectingu.R.id;
import com.example.connectingu.R.layout;
import com.example.connectingu.R.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserPref extends Activity {
	public static final String PREFS_NAME = "MyPrefsFile";

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
		
		
		
		EditText userEmailName = (EditText) findViewById(R.id.emailLine);
		String userEmail = userEmailName.getText().toString();
		
	
		EditText userName = (EditText) findViewById(R.id.uName);
		String uName = userName.getText().toString();
		
		EditText deletionCode = (EditText) findViewById(R.id.deletionCode);
		String deleteCode = deletionCode.getText().toString();
		
		if(userEmail.matches("") || uName.matches("") || deleteCode.matches("")){
			Context context = getApplicationContext();
			Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_LONG).show();
		}
		
		else{
			SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
			SharedPreferences.Editor e = myPrefs.edit();
			e.putString("uName", uName);
			e.putString("Email", userEmail);
			e.putString("delCode", deleteCode);
			e.commit();
			Intent intent = new Intent(this, MainMenu.class);
			startActivity(intent);
		}
		
		
	}
	public void cancel(View view){
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
