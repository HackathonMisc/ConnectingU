package com.example.connectingu;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.microsoft.windowsazure.mobileservices.*;
public class StartUp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		File file = new File("/data/data/" + getPackageName() +  "/shared_prefs/" + getPackageName()+ "_preferences.xml");
		if(file.exists()){
			Intent intent = new Intent(this, MainMenu.class);
			startActivity(intent);
		}
		else
		setContentView(R.layout.activity_start_up);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_up, menu);
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
	public void goToUserPref(View view){
		Intent intent = new Intent(this, UserPref.class);
		startActivity(intent);
	}
	
}
