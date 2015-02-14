package com.web.services;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static String SOAP_ACTION1 = "http://tempuri.org/FahrenheitToCelsius1";
    private static String SOAP_ACTION2 = "http://tempuri.org/CelsiusToFahrenheit";
    private static String NAMESPACE = "http://tempuri.org/";
    private static String METHOD_NAME1 = "FahrenheitToCelsius1";
    private static String METHOD_NAME2 = "CelsiusToFahrenheit";
    private static String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?WSDL";
    Button btnFar,btnCel,btnClear;
    EditText txtFar,txtCel;
    Handler handler;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFar = (Button)findViewById(R.id.button1);
        btnCel = (Button)findViewById(R.id.button2);
        btnClear = (Button)findViewById(R.id.button3);
        txtFar = (EditText)findViewById(R.id.editText1);
        txtCel = (EditText)findViewById(R.id.editText2);
       
        btnFar.setOnClickListener(new View.OnClickListener()
        {
                  @Override
                  public void onClick(View v)
                  {
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
              					Toast.makeText(MainActivity.this, response.getProperty("FirstName").toString(), 3000).show();
              				} catch (SoapFault e) {
              					e.printStackTrace();
              					System.out.println("DDDD");
              				}
              			}
              		};
              		SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME1);
              		soapObject.addProperty("Fahrenheit","12");
              	//	soapObject.addProperty("strPassword","rosyblue");
              		
              		
              		envelope.dotNet = true;
              		envelope.setOutputSoapObject(soapObject);
              		final HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
              		
              		new Thread(){
              			public void run() {
              				try {
              					httpTransportSE.call(SOAP_ACTION1, envelope);
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
        });
    }
              }




