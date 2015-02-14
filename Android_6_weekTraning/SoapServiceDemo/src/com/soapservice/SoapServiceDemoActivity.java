package com.soapservice;

import java.io.IOException;

import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class SoapServiceDemoActivity extends Activity {

	String serviceURL = "http://www.rosyblueonline.com/demo/webservices/rosyblueblackberryservice.asmx";
	String soapAction = "http://tempuri.org/CheckLogin";
	String operationName = "CheckLogin";
	String nameSpace = "http://tempuri.org/";
//	ProgressDialog progressDialog;
	Handler handler;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
//		progressDialog = ProgressDialog.show(this, "", "please wait...");
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER11);
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
		//		if (progressDialog != null) {
		//			progressDialog.dismiss();
		//		}
				try {
					SoapObject response = (SoapObject)envelope.getResponse();
					System.out.println("response "+response);
					System.out.println("FirstName "+response.getProperty("FirstName"));
					Toast.makeText(SoapServiceDemoActivity.this, response.getProperty("FirstName").toString(), 3000).show();
				} catch (SoapFault e) {
					e.printStackTrace();
					System.out.println("DDDD");
				}
			}
		};
		SoapObject soapObject = new SoapObject(nameSpace, operationName);
		soapObject.addProperty("strLoginName","customer");
		soapObject.addProperty("strPassword","rosyblue");
		
		
		envelope.dotNet = true;
		envelope.setOutputSoapObject(soapObject);
		final HttpTransportSE httpTransportSE = new HttpTransportSE(serviceURL);
		
		new Thread(){
			public void run() {
				try {
					httpTransportSE.call(soapAction, envelope);
					handler.sendEmptyMessage(0);
				} catch (IOException e) {
					System.out.println("AAAA");
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					e.printStackTrace();
					System.out.println("BBBB");
				}		
			};
		}.start();

	}
}




