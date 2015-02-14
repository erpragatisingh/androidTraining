package com.rajib.SmartKart;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class GetListofBooks extends Activity implements OnClickListener {
	/*
	 * This will list available books from the server
	 */

	int m, count, j = 0;

	private ProgressDialog qprogress;

	JSONParser jParser = new JSONParser();
	private static String url_get_books = "http://therajibdeb.com/SmartKart/GETBOOKS.php";
	private static String url_get_version = "http://therajibdeb.com/SmartKart/GetVersion.php";
	private static final String C_SUCCESS = "success";
	private static final String C_BOOKS = "Books";
	private static final String C_VERSION = "Version";
	private static final String C_VERSIONID = "VersionId";
	private static final String C_BOOKID = "BookId";
	private static final String C_ISBN = "ISBN";
	private static final String C_BOOKTITLE = "BookTitle";
	private static final String C_BOOKAUTHOR = "BookAuthor";
	private static final String C_PRICE = "Price";
	private static final String C_IMAGE = "Image";

	JSONArray books, Version = null;

	final List<String> booklist = new ArrayList<String>();
	Spinner spinner;

	String[][] results;
	ImageView imginstock;
	Button btAddCart;
	String selprice;
	BookTableOperations bookoperations;
	Bitmap bitmap2;
	ImageView imgbook;
	Bitmap imageicon;
	byte[] byteArray;
	String versionid = "0";
	String loaddata;
	String Name,EmailId;
	TextView tvwelcome;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_books);
		spinner = (Spinner) findViewById(R.id.spinner);
		btAddCart = (Button) findViewById(R.id.btAddCart);
		btAddCart.setOnClickListener(this);
		imgbook = (ImageView) findViewById(R.id.imgbook);
		bookoperations = new BookTableOperations(this);
		bookoperations.open();
		
		Intent i = getIntent(); 
		Name = i.getStringExtra("Name");
		EmailId = i.getStringExtra("EmailId");
		
		setTitle("Welcome " + Name);
		new RetrieveProducts().execute();

	}

	public void onDestroy() {
		super.onDestroy();
		bookoperations.close();
	}

	class RetrieveProducts extends AsyncTask<String, String, String> {
/*
 * (non-Javadoc)
 * @see android.os.AsyncTask#onPreExecute()
 * This piece of code will retrive the books from the server
 */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			qprogress = new ProgressDialog(GetListofBooks.this);
			qprogress.setMessage("Loading book data. Please wait...");
			qprogress.setIndeterminate(false);
			qprogress.setCancelable(false);
			qprogress.show();
		}

		/**
		 * getting All books from url
		 * */
		protected String doInBackground(String... args) {
			List<NameValuePair> parms = new ArrayList<NameValuePair>();

			JSONObject version_json = jParser.makeHttpRequest(url_get_version,
					"GET", parms);
			try {

				int success_version = version_json.getInt(C_SUCCESS);
				if (success_version == 1) {
					Version = version_json.getJSONArray(C_VERSION);
			
					for (int i = 0; i < Version.length(); i++) {
						JSONObject c = Version.getJSONObject(i);

						versionid = c.getString(C_VERSIONID);
								}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			loaddata = bookoperations.retrieveversion(versionid);
			/*
			 * If it is determined that a load will be needed based on the version code returned, 
			 * book data will be loaded to SQLITE database
			 */
			if (loaddata == "Y") {
				Log.d("inloaddata", "loaddata: " + loaddata);
				bookoperations.DeleteAllRows();
				bookoperations.retrieveversion(versionid);
				JSONObject json = jParser.makeHttpRequest(url_get_books, "GET",
						parms);
				try {

					int success = json.getInt(C_SUCCESS);

					if (success == 1) {
						books = json.getJSONArray(C_BOOKS);
						count = books.length();
						String column[] = new String[5];
						for (int i = 0; i < books.length(); i++) {
							JSONObject c = books.getJSONObject(i);

							column[0] = c.getString(C_BOOKID);
							column[1] = c.getString(C_BOOKTITLE);
							column[2] = c.getString(C_BOOKAUTHOR);
							column[3] = c.getString(C_ISBN);
							column[4] = c.getString(C_PRICE);

							try {
								URL imageUrl = new URL(c.getString(C_IMAGE));
								URLConnection ucon = imageUrl.openConnection();

								InputStream is = ucon.getInputStream();
								imageicon = BitmapFactory
										.decodeStream(new FlushedInputStream(is));

/*
 * Image is converted to bytearray and stored in SQLITE DATABASE
 */
								ByteArrayOutputStream stream = new ByteArrayOutputStream();
								imageicon.compress(Bitmap.CompressFormat.PNG,
										100, stream);
								byte[] byteArray = stream.toByteArray();

								if (loaddata == "Y") {
									bookoperations
											.createbookrow(column, byteArray);
								}
							} catch (Exception e) {
								return e.toString();
							}

						}

					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

				return null;
			}
		

		protected void onPostExecute(String file_url) {
			qprogress.dismiss();

			int bookcount = bookoperations.getCount();
			results = new String[bookcount][5];
			int bookcountconst;
			results = bookoperations.retrievebooks();
			for (bookcountconst = 0; bookcountconst < bookcount; bookcountconst++) {

				booklist.add(results[bookcountconst][1]);
			}

			ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
					GetListofBooks.this, R.layout.spinnerlayout, booklist);
			spinner.setAdapter(spinnerArrayAdapter);

			spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					byte[] bytes = bookoperations
							.retrieveimage(results[arg2][0].toString());

					/*
					 * Converting back to image
					 */
					bitmap2 = BitmapFactory.decodeByteArray(bytes, 0,
							bytes.length);
					TextView txtauthor = (TextView) findViewById(R.id.txtAuthor);
					TextView txtprice = (TextView) findViewById(R.id.txtPrice);
					txtauthor.setText("Author:" + results[arg2][2].toString());
					txtprice.setText("Price: USD "
							+ results[arg2][4].toString());

					imgbook.setImageBitmap(bitmap2);
					imginstock = (ImageView) findViewById(R.id.imginstock);
/*
 * Currently hardcoding the instock image
 */					
					String uri = "drawable/instock";

					int imageResource = getResources().getIdentifier(uri, null,
							getPackageName());

					Drawable image = getResources().getDrawable(imageResource);
					imginstock.setImageDrawable(image);
					selprice = results[arg2][4].toString();

				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// do nothing

				}

			});

		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v.getId() == R.id.btAddCart) {
/*
 * Move to the AddCart activity
 */
			Intent i = new Intent(getApplicationContext(), AddCart.class);
			i.putExtra("bookname", spinner.getSelectedItem().toString());
			i.putExtra("price", selprice);
			i.putExtra("Name", Name);
			i.putExtra("EmailId", EmailId);
			startActivity(i);

		}

	}
}
