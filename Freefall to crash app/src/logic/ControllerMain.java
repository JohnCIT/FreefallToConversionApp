package logic;

import java.text.DecimalFormat;

import com.example.madproj1.MainActivity;

import Conversion.Conversion;
import android.text.Editable;
import android.text.TextWatcher;

public class ControllerMain {
	
	MainActivity view;
	
	
	
	public ControllerMain(){}
	
	public ControllerMain(MainActivity view) {
		this.view = view;

		
		
		
		view.inputTextChange(new KmhInput());
	}
	
	
	
	
	
	
	/**
	 * When the text changes in the field implement the changes here
	 */
	public class KmhInput implements TextWatcher {

		public void afterTextChanged(Editable s) {
			double freeFall;
			
			//Format to 2 decimal places
			DecimalFormat df = new DecimalFormat("#.##");
			

			int km 	 = view.getKmh(); //Get the input
			freeFall = Conversion.kmhToFreeFallHeight(km); //Convert the input
			
			
			//Display the value
			view.setFreeFallOutPut(df.format(freeFall));
		}
		
		//Unused
		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}		
		//Unused
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
		
	}

}
