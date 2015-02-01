package com.example.connectingu;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Buy extends ActionBarActivity {
	
	private List<textBookModel> textBooks = new ArrayList<textBookModel>(); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
	           
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
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
	
	private void populateList(){
		ArrayAdapter<textBookModel> adepter = new MyListAdepter();
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adepter);
	}
	
	private class MyListAdepter extends ArrayAdapter<textBookModel>{
		public MyListAdepter(){
			super(Buy.this, R.layout.item_view, textBooks);
		}
		public View getView(int position, View convertView, ViewGroup parent){
			View itemView = convertView;
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
			}
			//Still need to get the position on the list
			
			//Replace Test with the actual title from the object
			TextView title = (TextView) itemView.findViewById(R.id.ListTitle);
			title.setText("Test");
			
			
			
			return itemView;
		}
	}
}
