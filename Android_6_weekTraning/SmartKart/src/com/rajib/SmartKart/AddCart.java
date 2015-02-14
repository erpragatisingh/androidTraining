
package com.rajib.SmartKart;

import java.math.BigDecimal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 * This Activity will add the books into the cart and will take the user to the screen from where user 
 * will be able to mention the quantity and proceed to checkout 
 */
public class AddCart extends Activity implements OnClickListener{
	
	BigDecimal price,totprice,Quantity;
	TextView tvBookname,tvPrice,tvTotal;
	EditText edQuantity;
	Button btCalc,btPurchase;
	String bookname,pricestring,Name,EmailId;
	int RETURN_CODE = 1;
	

	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_show_cart);
	        Intent i = getIntent(); 
	        bookname = i.getStringExtra("bookname"); 
	        pricestring = i.getStringExtra("price"); 
	        Name = i.getStringExtra("Name");
	        EmailId = i.getStringExtra("EmailId");
	        price = new BigDecimal(pricestring);
	        
	        tvBookname = (TextView) findViewById(R.id.tvBookname);
	        tvPrice = (TextView) findViewById(R.id.tvPrice);
	        btCalc = (Button)findViewById(R.id.btCalc);
	        btPurchase= (Button)findViewById(R.id.btPurchase);
	        edQuantity = (EditText)findViewById(R.id.editQuantity);
	        edQuantity.setText("1");
	        Quantity =new BigDecimal( Integer.parseInt(edQuantity.getText().toString()));
	        tvTotal=(TextView)findViewById(R.id.tvTotalcalc);
	        tvBookname.setText(bookname);
	        tvPrice.setText("$" + pricestring);
	        btCalc.setOnClickListener(this);
	        btPurchase.setOnClickListener(this);
	        totprice = price.multiply(new BigDecimal( Integer.parseInt(edQuantity.getText().toString())));
	        tvTotal.setText("$"+ totprice.toPlainString());
	        /*
	         * This sets the title bar to the user name
	         */
	        
	        setTitle("Welcome " + Name);
	}
	   
	   
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			   super.onActivityResult(requestCode, resultCode, data);
			   if (requestCode == RETURN_CODE && resultCode == 1) {
			        //If successfully returned from PurchaseActivity
			    	
			    	Intent indata = new Intent();
					setResult(1, indata);
					finish();
			    } else
			    {
			    	//If not successfully returned from PurchaseActivity
			    	
			    	Intent indata = new Intent();
					setResult(0, indata);
					finish();
			    }
			}
			

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v.getId() == R.id.btCalc) {
/*
 * If the CALC button is clicked then the total price is calculated
 */
			Quantity =new BigDecimal( Integer.parseInt(edQuantity.getText().toString()));
			totprice = price.multiply(Quantity);
			tvTotal.setText("$"+ totprice.toPlainString());
		}
		else if(v.getId() == R.id.btPurchase)
		{
/*
 * This will take the user to the PurchaseActivity where user can fill credit card details
 */
			Intent i = new Intent(getApplicationContext(), PurchaseActivity.class);
			i.putExtra("ItemName", bookname);
			i.putExtra("Quantity", String.valueOf(Quantity));
			i.putExtra("TotalPrice", String.valueOf(totprice));
			i.putExtra("Name", Name);
			i.putExtra("EmailId",EmailId);
			startActivityForResult(i, RETURN_CODE);

		}
	}

}
