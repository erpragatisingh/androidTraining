package com.coderzheaven;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TextView;

public class ReadXML extends Activity {
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.main);
	    
	      TextView myXmlContent = (TextView)findViewById(R.id.xml_tv);
	      String stringXmlContent;
	      
		  stringXmlContent = getAllXML();
		  myXmlContent.setText(stringXmlContent);
		
	  }

	  public String getAllXML(){
		  
		  Activity activity = this;
		  String str = "";
		  
		  Resources res = activity.getResources();
		  XmlResourceParser xpp = res.getXml(R.xml.test);
		  
		  try {
				xpp.next();
				int eventType = xpp.getEventType();
				System.out.println("eventType : " + eventType);
				while (eventType != XmlPullParser.END_DOCUMENT)
			    {
					 if(eventType == XmlPullParser.START_DOCUMENT){
						 str += "\nXML Parsing Starting...\n";
					 }
					 else if(eventType == XmlPullParser.START_TAG)
				     {
						 str +=  "\nroot tag: "+xpp.getName();
				     }
				     else if(eventType == XmlPullParser.END_TAG)
				     {
				    	 str += "\nending tag: "+xpp.getName();
				     }
				     else if(eventType == XmlPullParser.TEXT)
				     {
				    	 str += "\nvalue : "+xpp.getText();
				     }
				     eventType = xpp.next();
			    }
				 str += "\n\nXML parsing Ending......";
				 
		  } catch (XmlPullParserException e) {
				e.printStackTrace();
		  } catch (IOException e) {
				e.printStackTrace();
		  }
		  return str;		  
	  }
	 
	}