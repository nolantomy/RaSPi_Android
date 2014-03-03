package com.nolan.tom.raspi;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainMenu extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			//setContentView(R.layout.activity_main_menu);
			String[] values = new String[] { "Android", "iPhone",
					"WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
					"Windows7", "Max OS X", "Linux", "OS/2" };
			ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
			        R.layout.activity_main_menu, R.id.label, values);
			setListAdapter(adapter);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menue, menu);
		return true;
	}

}
