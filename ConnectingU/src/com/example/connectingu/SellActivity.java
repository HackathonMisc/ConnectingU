package com.example.connectingu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SellActivity extends ActionBarActivity {
	String FILENAME = "userName"; // save user name
	String FILENAME2 = "email"; // save email
	String FILENAME3 = "deletion"; // save deletion code
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
	public void publishBook(View view){
		SharedPreferences myPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
		String name = myPrefs.getString("uName", "Student");
		Toast.makeText(this, name, Toast.LENGTH_LONG).show();
				
		
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
}
