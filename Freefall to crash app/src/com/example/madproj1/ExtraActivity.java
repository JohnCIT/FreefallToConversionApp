package com.example.madproj1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ExtraActivity extends Activity {

	private String userName;

	private TextView userNameInput;







	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extra);
		
		//Change background colour
		getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);	

		//Get the button
		Button goBack = (Button) findViewById(R.id.goToMain);

		//Get the text view
		userNameInput = (TextView) findViewById(R.id.userNameField);

		//Get the intent
		Intent intent = getIntent();		
		userName	  = intent.getStringExtra("userName");

		//Set the text from the variable
		userNameInput.setText(userName);


		//Add the action listener to the field
		userNameInput.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				userName = getUserNameText();			
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}	
			public void afterTextChanged(Editable s) {}
		});






		//Add a click listener to the button
		goBack.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent intent = getIntent();
				intent.putExtra("userName", userName);

				//Set the intent result
				setResult(RESULT_OK, intent);

				finish();	
			}
		});


	}





	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.extra, menu);
		return true;
	}





	/////////////////////////Component manipulation////////////////


	/**
	 * Get the text from the field
	 */
	private String getUserNameText() {
		CharSequence name = userNameInput.getText();
		return name.toString();
	}













}
