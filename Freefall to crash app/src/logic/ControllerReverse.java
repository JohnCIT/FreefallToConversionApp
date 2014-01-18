package logic;

import java.text.DecimalFormat;

import Conversion.Conversion;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.madproj1.ReverseActivity;

public class ControllerReverse {
	
	ReverseActivity view;
	
	
	public ControllerReverse() {}
	
	
	public ControllerReverse(ReverseActivity view) {
		this.view = view;
		
		//Assign the action listener 
		view.setFreeFallInAction(new freeFallIn());
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * The action taken when the free fall input is done
	 */
	public class freeFallIn implements TextWatcher{
		public void afterTextChanged(Editable s) {
			
			double input = view.getFreeFallInput();
			

			//Format to 2 decimal places
			DecimalFormat df = new DecimalFormat("#.##");
						
			input = Conversion.heightToKmh(input);
			
			view.setkmhOutViewMsg(df.format(input));
						
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {}
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {}
	}
	
	

}
