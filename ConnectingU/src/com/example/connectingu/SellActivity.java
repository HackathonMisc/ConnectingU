package com.example.connectingu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

public class SellActivity extends Activity {
	private MobileServiceClient mClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		mClient = new MobileServiceClient(
			      "https://createuhack.azure-mobile.net/",
			      "VYUFlTqdDvsVILWwLeXVWBhwmfHMMY55",
			      this
			);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
	public void publisBook(){
		
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
