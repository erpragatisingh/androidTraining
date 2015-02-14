package com.java.sax;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.javatpoint.saxxmlparsing.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;

	@Override
//	Bundle	A mapping from String values to various Parcelable types.
	// Parcelable -it is interface ,created object 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//Set the activity content from a layout resource. The resource will be inflated, adding all top-level views to the activity.
//  void android.app.Activity.setContentView(int layoutResID)

		tv = (TextView) findViewById(R.id.textView1);
//Finds a view that was identified by the id attribute 
//from the XML that was processed in onCreate(Bundle).

		
		try {
			//javax.xml.parsers.SAXParserFactory
//Defines a factory API that enables applications to configure 
//and obtain a SAX based parser to parse XML documents.
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler()
////SAX2 applications: it provides default implementations 
//for all of the callbacks in the four core SAX2 handler classes:
//
//EntityResolver 
//DTDHandler 
//ContentHandler 
//ErrorHandler 
//Application writers can extend this class when they
//need to implement only part of an interface; parser writers can instantiate this class to provide default handlers when the application has not supplied its own.
//
//This class replaces the deprecated SAX1 HandlerBase class.

{
				boolean name = false;
				boolean salary = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
//				Receive notification of the start of an element. 
//
//	By default, do nothing. Application writers
//may override this method in a subclass to take specific
//actions at the start of each element 
//(such as allocating a new tree node or writing output to a file).
//	Parameters
//		uri  The Namespace URI, or the empty string if the element has 
		//no Namespace URI or if Namespace processing is not being performed. 
//		localName  The local name (without prefix), or the empty string if
				//Namespace processing is not being performed. 
//		qName  The qualified name (with prefix), or the empty string 
				//if qualified names are not available. 
//		attributes  The attributes attached to the element.
				//If there are no attributes, it shall be an empty Attributes object. 
//
//				Throws
//				SAXException  Any SAX exception, possibly wrapping another exception. 


						throws SAXException {
					if (qName.equalsIgnoreCase("name")) {
						name = true;
					}
					if (qName.equalsIgnoreCase("salary")) {
						salary = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (name) {
						tv.setText(tv.getText() + "\n\n Name : "
								+ new String(ch, start, length));
						name = false;
					}
					if (salary) {
						tv.setText(tv.getText() + "\n Salary : "
								+ new String(ch, start, length));
						salary = false;
					}
				}// end of characters
			};// end of DefaultHandler

			InputStream is = getAssets().open("file.xml");
//	Most clients will use input streams that read data from the file 
//	system (FileInputStream), the network (getInputStream()/getInputStream()),
//	or from an in-memory byte array (ByteArrayInputStream). 
//
//	Use InputStreamReader to adapt a byte stream like this one into a character stream. 
//
//	Most clients should wrap their input stream with BufferedInputStream.
//	Callers that do only bulk reads may omit buffering. 

			saxParser.parse(is, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
