package com.rajib.SmartKart;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/*
 * This is the Activity where user inputs credit card details to buy the books
 */

public class PurchaseActivity extends Activity implements OnClickListener {

	String Name,EmailId,bookname,TotalPricestring,Quantitystring,OrderId,Currency;
	Button btCheckout;
	EditText PurchaserName;
	EditText PurchaserAddress;
	
	
	int RETURN_CODE = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_payment_popup);
		Intent i = getIntent(); 
		Name = i.getStringExtra("Name");
		EmailId = i.getStringExtra("EmailId");
        bookname = i.getStringExtra("ItemName");
        Quantitystring = i.getStringExtra("Quantity");
        TotalPricestring = i.getStringExtra("TotalPrice");
        PurchaserName = (EditText)findViewById(R.id.editName);
        PurchaserAddress = (EditText)findViewById(R.id.edAddress);
        Currency = "USD";
        
        Random rand = new Random(); 
        /*
         * Gets the number for the order ID. Random number is used to get unique number
         */
        OrderId = "O" + rand.nextInt(90); 
        
        setTitle("Welcome " + Name);
        btCheckout =(Button)findViewById(R.id.btsubmit);
        
        btCheckout.setOnClickListener(this);
        }

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		   super.onActivityResult(requestCode, resultCode, data);
		    if (requestCode == RETURN_CODE && resultCode == 1) {
		        //get value from intent
		    	
		    	Intent indata = new Intent();
				setResult(1, indata);
				finish();
		    } else
		    {
		    	Intent indata = new Intent();
				setResult(0, indata);
				finish();
		    }
		}
		
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btsubmit) {
/*
 * on submit, stores the purchase data in the database
 */
			Intent i = new Intent(getApplicationContext(), Checkout.class);
			i.putExtra("OrderId", OrderId);
			i.putExtra("Name", Name);
			i.putExtra("EmailId", EmailId);
			i.putExtra("Address", PurchaserAddress.getText().toString());			
			i.putExtra("ItemDesc", bookname);
			i.putExtra("Quantity", Quantitystring);
			i.putExtra("TotalPrice", TotalPricestring);
			i.putExtra("Currency", Currency);
			startActivityForResult(i, RETURN_CODE);

		}
		
	}

	
}
