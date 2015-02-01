package com.example.connectingu;

import java.net.MalformedURLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

public class SellActivity extends Activity {
	private MobileServiceClient mClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		try {
			mClient = new MobileServiceClient(
				      "https://createuhack.azure-mobile.net/",
				      "VYUFlTqdDvsVILWwLeXVWBhwmfHMMY55",
				      this
				);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public class Item {
	      public String TextBookName;
	      public String Price;
	      public String CourseID;
	      public String Description;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}
	public void publisBook(View view){
		Item item = new Item();
		
		EditText Decsrip = (EditText) findViewById(R.id.bookDescription);
		String Description = Decsrip.getText().toString();
		
	
		EditText CId = (EditText) findViewById(R.id.courseId);
		String courseID = CId.getText().toString();
		
		EditText name = (EditText) findViewById(R.id.textBookName);
		String names = name.getText().toString();
		

		EditText pr = (EditText) findViewById(R.id.Price);
		String price = pr.getText().toString();
		
		item.TextBookName = names;
		item.Price = price;
		item.CourseID = courseID;
		item.Description = Description;
		
		mClient.getTable(Item.class).insert(item, new TableOperationCallback<Item>() {
		      public void onCompleted(Item entity, Exception exception, ServiceFilterResponse response) {
		            if (exception == null) {
		                  // Insert succeeded
		            } else {
		                  // Insert failed
		            }
		      }
		});
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
