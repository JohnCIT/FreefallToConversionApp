package com.example.madproj1;

import logic.ControllerReverse;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReverseActivity extends Activity {

	
	int kmh;
	double freeFall;
	
	//Create the text view
	private TextView kmhOut;
	private TextView freeFallIn;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_data_back);
		
		
		//Change background colour
		getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
		
		//Get the button component
		Button goBack = (Button) findViewById(R.id.goBackFromExtra);
		
		//Get the text view components
		kmhOut 		= (TextView) findViewById(R.id.kmhOutPutView);
		freeFallIn 	= (TextView) findViewById(R.id.freeFallInputView); 
		
		//Add action listener
		goBack.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		
		//Get the variables passed in
		//Get the intent passed in
		Intent intent = getIntent();
		kmh 	 = intent.getIntExtra("userKmInput", 0);
		freeFall = intent.getDoubleExtra("freeFallOut", 0);
		
		//Set the view back up
		setkmhOutViewMsg(String.valueOf(kmh));
		setFrefallInputMsg(String.valueOf(freeFall));		
		
		
		
		
		new ControllerReverse(this);		
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_data_back, menu);
		return true;
	}
	
	
	
	


	
	//////////////////////////////////Component manipulation///////////////////////
	
	/**
	 * Set the kmh out put view
	 */
	public void setkmhOutViewMsg(String msg) {
		kmhOut.setText(msg);
	}
	
	
	
	/**
	 * Set the freeFall input view
	 */
	public void setFrefallInputMsg(String msg) {
		freeFallIn.setText(msg);
	}
	
	

	/**
	 * Get the kmh output
	 */
	public double getkmhOutView() {
		CharSequence kmhOutView = kmhOut.getText();
		
		//Check if the field is empty
		if(kmhOutView.toString().length() != 0) {
			return Double.parseDouble(kmhOutView.toString());
		}
		
		return 0;			
	}
	
	
	
	/**
	 * Get the freeFall input
	 */
	public double getFreeFallInput() {
		CharSequence freeFallInPut = freeFallIn.getText();
		
		//Check if the field is empty
		if(freeFallInPut.toString().length() != 0) {
			return Double.parseDouble(freeFallInPut.toString());
		}
		
		return 0;			
	}
	
	
	
	
	
	/////////////////////////////////Add action listeners///////////////////////////////
	
	/**
	 * Add the action listener to the free fall input
	 */
	public void setFreeFallInAction(TextWatcher tw) {
		freeFallIn.addTextChangedListener(tw);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
