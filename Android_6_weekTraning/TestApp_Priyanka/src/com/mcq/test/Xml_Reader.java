package com.mcq.test;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//import android.sax.Element;

public class Xml_Reader {
	
	public static String getXML(String url){
		String line = null;
		try {
		       DefaultHttpClient httpClient = new DefaultHttpClient();
		       HttpPost httpPost = new HttpPost(url);
		       HttpResponse httpResponse = httpClient.execute(httpPost);
		       HttpEntity httpEntity = httpResponse.getEntity();
		       line = EntityUtils.toString(httpEntity);
		}
		catch (UnsupportedEncodingException e) {
			   line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		}
		catch (MalformedURLException e) {
				line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		}
		catch (IOException e) {
		        line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		}
		return line;

	}
	
	public Document XMLfromString(String xml){
	    Document doc = null;
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource();
	        is.setCharacterStream(new StringReader(xml));
	        doc = db.parse(is);
	    } 
	    catch (ParserConfigurationException e) {
	        System.out.println("XML parse error: " + e.getMessage());
	        return null;
	    }
	    catch (SAXException e) {
	        System.out.println("Wrong XML file structure: " + e.getMessage());
	        return null;
	    }
	    catch (IOException e) {
	         System.out.println("I/O exeption: " + e.getMessage());
	         return null;
	    }
	    return doc;
	
	}
	public String getValue(Element item, String str) {
		try{
			NodeList n =  item.getElementsByTagName(str);
			return this.getElementValue(n.item(0));
		}
		catch(Exception e){
			System.out.println("Inside getValue()");
			e.printStackTrace();
		}
		return null;
	}
	 
	public final String getElementValue( Node elem ) {
	    Node child;
	    if( elem != null){
	    	if (elem.hasChildNodes()){
	    		for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
	    			if( child.getNodeType() == Node.TEXT_NODE  ){
	    				return child.getNodeValue();
	                 }
	             }
	        }
	    }
	    return "";
	 } 
}
