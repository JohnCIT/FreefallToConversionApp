package com.example.madproj1;

/**
 * John Murphy
 * R00059277
 * john.murphy7@mycit.ie
 */


import logic.ControllerMain;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextWatcher;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;



public class MainActivity extends Activity {


	//Make components 
	private TextView kmhInput;
	private TextView freeFallOutPut;
	private TextView extraView;
	
	private static final int GET_EXTRA_DATA = 2020;
	private int appVisit;
	private String userName;
	
	private int uselessSave;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//Change background colour
		getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);	
		
		//Takes any data that has been saved to the phone and assigns it to the variables
		SharedPreferences savedVars = getSharedPreferences("PrefName", Context.MODE_PRIVATE);
		appVisit = savedVars.getInt("appVisit", 0);
		userName = savedVars.getString("userName", "");
		
		//Increment the app visits var
		appVisit++;
			
		//Get the buttons
		Button goToExtra  = (Button) findViewById(R.id.goToExtras);
		Button doReverse  = (Button) findViewById(R.id.reverse);
		
		//Assign the components so they can be seen through out the class
		kmhInput 		= (TextView) findViewById(R.id.freeFallInputView);
		freeFallOutPut 	= (TextView) findViewById(R.id.freeFallOutPut); 
		extraView		= (TextView) findViewById(R.id.extra);
		
		//Set the label
		extraView.setText("Hello " + userName + ": " + "App visits: " + appVisit);
		
		//Add a action a listener to the button
		goToExtra.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToExtrasScreen();				
			}
		});
		
		
		
		//Add the action listener to go the third screen to do the calculation
		doReverse.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToReverseCalc();		
			}
		});
		
		//Save the details	
		SharedPreferences saveVars = getSharedPreferences("PrefName", Context.MODE_PRIVATE);
		saveVars.edit().putString("userName", userName)
				.putInt("appVisit", appVisit).commit();

		//Create a controller
		new ControllerMain(this);
	}
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	
	
	
	/**
	 * Go to the extra info screen
	 */
	public void goToExtrasScreen() {
		Intent goToScreenExtra = new Intent(this, ExtraActivity.class);
		
		goToScreenExtra.putExtra("userName", userName);
				
		startActivityForResult(goToScreenExtra, GET_EXTRA_DATA);
	}
	
	
	
	
	
	
	/**
	 * Get to the intent to reverse the equation 
	 */
	public void goToReverseCalc() {
		Intent goToReverseCalc = new Intent(this, ReverseActivity.class);
		
		goToReverseCalc.putExtra("userKmInput", getKmh());
		goToReverseCalc.putExtra("freeFallOut", getFreeFallOutput());
		
		startActivity(goToReverseCalc);
	}
	
	
	
	
	
	
	/**
	 * Get the result back from the intent
	 */
	protected void onActivityResult(int requestCode,
            int resultCode, Intent data) {
    	
        if (requestCode == GET_EXTRA_DATA && resultCode == RESULT_OK) {  
            userName = data.getExtras().getString("userName");     
           
            extraView.setText("Hello " + userName + ":" + " App visits: " + appVisit);
        }
        
      //Save the details here as well so the latest information is saved
      SharedPreferences saveVars = getSharedPreferences("PrefName", Context.MODE_PRIVATE);
      saveVars.edit().putString("userName", userName)
      		  .putInt("appVisit", appVisit).commit();
        
        
        super.onActivityResult(requestCode, resultCode, data);
    }
	
	
	
	
	
	/**
	 * Save the instance so when the the screen rotates the variables are saved
	 */
	public void onSaveInstanceState(Bundle outState) {
	//Save the state
	uselessSave = appVisit;
	outState.putInt("noNeed", uselessSave);
	super.onSaveInstanceState(outState); 
	}
	
	
	
	
	/**
	 * Restore the saved variables
	 */
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	super.onRestoreInstanceState(savedInstanceState);

	//Get the saved data
	uselessSave = savedInstanceState.getInt("noNeed");
	
	//For test purposes print the variable
	System.out.println("No need for this: " + uselessSave);
	}
	
	
	
		
	///////////////////////////Actions for components////////////////////////////
	
	
	
	
	
	/**
	 * Add the listener to the input area
	 */
	public void inputTextChange(TextWatcher tw) {
		kmhInput.addTextChangedListener(tw);
	}
	
	
	
	
	
	
	//////////////////////////Component manipulation//////////////////////////////
	
	/**
	 * Get the kmh from the input field
	 * @return The KMH
	 */
	public int getKmh() {
		CharSequence input = kmhInput.getText();
		//Check if string is null
		if(input.toString().length() != 0) {
			return Integer.parseInt(input.toString());
		}
		
		return 0;	
	}
	
	
	
	
	
	/**
	 * Set the text into the freeFall output
	 */
	public void setFreeFallOutPut(String msg) {
		freeFallOutPut.setText(msg);
	}
	
	
	
	
	
	/**
	 * Get the free fall output
	 * @return the out of the free fall
	 */
	public double getFreeFallOutput() {
		CharSequence freeFallOut = freeFallOutPut.getText();
		//Check if the string is null
		if(freeFallOut.toString().length() != 0) {
			return Double.parseDouble(freeFallOut.toString());
		}
		
		return 0;	
	}
	
	
	
	
	
	
	
	
	

}
