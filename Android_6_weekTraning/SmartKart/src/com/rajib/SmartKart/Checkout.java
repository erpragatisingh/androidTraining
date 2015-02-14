package com.rajib.SmartKart;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/*
 * This is the last activity in the flow. Shows the result of purchase
 */

public class Checkout extends Activity implements OnClickListener {

	private ProgressDialog qprogress;

	JSONParser jParser = new JSONParser();
	private static String URL_CREATE_ORDER = "http://therajibdeb.com/SmartKart/ORDER.php";
	private static final String TAG_SUCCESS = "success";
	int success;
	String results;
	JSONArray users = null;
	String OrderId, UserId, ItemDesc, Address, Quantity, TotalPrice, Currency,
			Name;
	Button btOk;
	TextView tvordercomplete;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_complete);
		tvordercomplete = (TextView) findViewById(R.id.tvOrderComplete);
		btOk = (Button) findViewById(R.id.btOk);
		btOk.setOnClickListener(this);

		Intent i = getIntent();
		OrderId = i.getStringExtra("OrderId");
		Name = i.getStringExtra("Name");
		UserId = i.getStringExtra("EmailId");
		Address = i.getStringExtra("Address");
		ItemDesc = i.getStringExtra("ItemDesc");
		Quantity = i.getStringExtra("Quantity");
		TotalPrice = i.getStringExtra("TotalPrice");
		Currency = i.getStringExtra("Currency");

		new CreateOrder().execute();
	}

	class CreateOrder extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			qprogress = new ProgressDialog(Checkout.this);
			qprogress.setMessage("Processing Order. Please wait...");
			qprogress.setIndeterminate(false);
			qprogress.setCancelable(false);
			qprogress.show();
		}

		protected String doInBackground(String... parms) {
			// TODO Auto-generated method stub
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("OrderId", OrderId));
			params.add(new BasicNameValuePair("UserId", UserId));
			params.add(new BasicNameValuePair("Address", Address));
			params.add(new BasicNameValuePair("ItemDesc", ItemDesc));
			params.add(new BasicNameValuePair("Quantity", Quantity));
			params.add(new BasicNameValuePair("Currency", Currency));
			params.add(new BasicNameValuePair("TotalPrice", TotalPrice));

			JSONObject order_json = jParser.makeHttpRequest(URL_CREATE_ORDER,
					"POST", params);
			try {
				success = order_json.getInt(TAG_SUCCESS);
				Log.d("success_oder", "rajib" + success);
				if (success == 1) {
					results = "OK";
					Intent data = new Intent();
					setResult(1, data);
				} else {
					results = "ERROR";
					Intent data = new Intent();
					setResult(0, data);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return results;
		}

		protected void onPostExecute(String results) {

			if (results == "OK") {
				tvordercomplete
						.setText("Dear "
								+ Name
								+ "Your Order has been successfully processed."
								+ "We appreciate your business with us. Your item will be shipped in the next "
								+ "business day. In case you need further assistance, please call us at "
								+ "1-888-884-1908");
			} else {
				tvordercomplete
						.setText("Dear "
								+ Name
								+ "Your Order could not be processed at this time."
								+ "We apologize for the inconvenience. Please try after sometimes. "
								+ "In case you need further assistance, please call us at "
								+ "1-888-884-1908");
			}
			qprogress.dismiss();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*
		 * if user clicks OK, he will be taken back to GetListofBooks activity
		 */
		if (v.getId() == R.id.btOk) {

			finish();

		}

	}

}
