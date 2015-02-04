package com.example.connectingu.views;

import com.example.connectingu.R;
import com.example.connectingu.Data.dataController;
import com.example.connectingu.R.id;
import com.example.connectingu.R.layout;
import com.example.connectingu.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Start extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		dataController dC = new dataController();
		dC.setContext(getBaseContext());
		if(getSharedPreferences("myPrefs", Context.MODE_PRIVATE) != null){
			Intent intent = new Intent(this, MainMenu.class);
			startActivity(intent);
		}
		else{
			setContentView(R.layout.activity_start_up);
			Intent intent = new Intent(this, UserPref.class);
			startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
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
}
