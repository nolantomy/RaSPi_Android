package com.nolan.tom.raspi;

import com.nolan.tom.raspi.Logic.RaspberrySPi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent(this, Register_User.class);
		final RaspberrySPi raspb = RaspberrySPi.getInstance();
		final EditText username = (EditText) findViewById(R.id.Username);
		final EditText password = (EditText) findViewById(R.id.password);
		final Button submit = (Button) findViewById(R.id.submit);
		final TextView register = (TextView) findViewById(R.id.register);
		
		//Login a User
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				raspb.registerNewUser(username.getText().toString(), password.getText().toString());
				
			}
		});//end of on click
		
		//Redirect to Register
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
