package com.example.xmlpullparsing;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParserHandler {
	private List<Employee> employees = new ArrayList<Employee>();
	private Employee employee;
	private String text;

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Employee> parse(InputStream is) {
		/*
		 * org.xmlpull.v1.XmlPullParser
		 * 
		 * 
		 * 
		 * There are following different kinds of parser depending on which
		 * features are set:
		 * 
		 * non-validating parser as defined in XML 1.0 spec when
		 * FEATURE_PROCESS_DOCDECL is set to true validating parser as defined
		 * in XML 1.0 spec when FEATURE_VALIDATION is true (and that implies
		 * that FEATURE_PROCESS_DOCDECL is true) when FEATURE_PROCESS_DOCDECL is
		 * false (this is default and if different value is required necessary
		 * must be changed before parsing is started) then parser behaves like
		 * XML 1.0 compliant non-validating parser under condition that no
		 * DOCDECL is present in XML documents (internal entites can still be
		 * defined with defineEntityReplacementText()). This mode of operation
		 * is intended for operation in constrained environments such as J2ME.
		 * There are two key methods: next() and nextToken(). While next()
		 * provides access to high level parsing events, nextToken() allows
		 * access to lower level tokens.
		 * 
		 * The current event state of the parser can be determined by calling
		 * the getEventType() method. Initially, the parser is in the
		 * START_DOCUMENT state.
		 * 
		 * The method next() advances the parser to the next event. The int
		 * value returned from next determines the current parser state and is
		 * identical to the value returned from following calls to getEventType
		 * ().
		 * 
		 * Th following event types are seen by next()
		 * 
		 * START_TAG An XML start tag was read. TEXT Text content was read; the
		 * text content can be retrieved using the getText() method. (when in
		 * validating mode next() will not report ignorable whitespace, use
		 * nextToken() instead) END_TAG An end tag was read END_DOCUMENT No more
		 * events are available after first next() or nextToken() (or any other
		 * next*() method) is called user application can obtain XML version,
		 * standalone and encoding from XML declaration in following ways:
		 * 
		 * version:
		 * getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-version"
		 * ) returns String ("1.0") or null if XMLDecl was not read or if
		 * property is not supported standalone: getProperty(
		 * "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone")
		 * returns Boolean: null if there was no standalone declaration or if
		 * property is not supported otherwise returns Boolean(true) if
		 * standalone="yes" and Boolean(false) when standalone="no" encoding:
		 * obtained from getInputEncoding() null if stream had unknown encoding
		 * (not set in setInputStream) and it was not declared in XMLDecl A
		 * minimal example for using this API may look as follows: import
		 * java.io.IOException; import java.io.StringReader;
		 * 
		 * import org.xmlpull.v1.XmlPullParser; import
		 * org.xmlpull.v1.XmlPullParserException; import
		 * org.xmlpull.v1.XmlPullParserFactory;
		 * 
		 * public class SimpleXmlPullApp {
		 * 
		 * public static void main (String args[]) throws
		 * XmlPullParserException, IOException { XmlPullParserFactory factory =
		 * XmlPullParserFactory.newInstance(); factory.setNamespaceAware(true);
		 * XmlPullParser xpp = factory.newPullParser();
		 * 
		 * xpp.setInput( new StringReader ( "<foo>Hello World!</foo>" ) ); int
		 * eventType = xpp.getEventType(); while (eventType !=
		 * XmlPullParser.END_DOCUMENT) { if(eventType ==
		 * XmlPullParser.START_DOCUMENT) { System.out.println("Start document");
		 * } else if(eventType == XmlPullParser.START_TAG) {
		 * System.out.println("Start tag "+xpp.getName()); } else if(eventType
		 * == XmlPullParser.END_TAG) {
		 * System.out.println("End tag "+xpp.getName()); } else if(eventType ==
		 * XmlPullParser.TEXT) { System.out.println("Text "+xpp.getText()); }
		 * eventType = xpp.next(); } System.out.println("End document"); } }
		 * 
		 * The above example will generate the following output:
		 * 
		 * Start document Start tag foo Text Hello World! End tag foo End
		 * document
		 * 
		 * For more details on API usage, please refer to the quick Introduction
		 * available at http://www.xmlpull.org
		 * 
		 * See Also XmlPullParserFactory defineEntityReplacementText(String,
		 * String) getName() getNamespace() getText() next() nextToken()
		 * setInput(InputStream, String) FEATURE_PROCESS_DOCDECL
		 * FEATURE_VALIDATION START_DOCUMENT START_TAG TEXT END_TAG END_DOCUMENT
		 * Summary Constants int CDSECT A CDATA sections was just read; this
		 * token is available only from calls to nextToken(). int COMMENT An XML
		 * comment was just read. int DOCDECL An XML document type declaration
		 * was just read. int END_DOCUMENT Logical end of the xml document. int
		 * END_TAG Returned from getEventType(), next(), or nextToken() when an
		 * end tag was read. int ENTITY_REF An entity reference was just read;
		 * this token is available from nextToken() only. String
		 * FEATURE_PROCESS_DOCDECL This feature determines whether the document
		 * declaration is processed. String FEATURE_PROCESS_NAMESPACES This
		 * feature determines whether the parser processes namespaces. String
		 * FEATURE_REPORT_NAMESPACE_ATTRIBUTES This feature determines whether
		 * namespace attributes are exposed via the attribute access methods.
		 * String FEATURE_VALIDATION If this feature is activated, all
		 * validation errors as defined in the XML 1.0 specification are
		 * reported. int IGNORABLE_WHITESPACE Ignorable whitespace was just
		 * read. String NO_NAMESPACE This constant represents the default
		 * namespace (empty string "") int PROCESSING_INSTRUCTION An XML
		 * processing instruction declaration was just read. int START_DOCUMENT
		 * Signalize that parser is at the very beginning of the document and
		 * nothing was read yet. int START_TAG Returned from getEventType(),
		 * next(), nextToken() when a start tag was read. int TEXT Character
		 * data was read and will is available by calling getText().
		 */try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true); // DEFAULT FALSE
			XmlPullParser parser = factory.newPullParser(); 
			//Creates a new instance of a XML 

			parser.setInput(is, null);

			int eventType = parser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				String tagname = parser.getName();
				switch (eventType) {
				case XmlPullParser.START_TAG:
					if (tagname.equalsIgnoreCase("employee")) {
						// create a new instance of employee
						employee = new Employee();
					}
					break;

				case XmlPullParser.TEXT:
					text = parser.getText();
					break;

				case XmlPullParser.END_TAG:
					if (tagname.equalsIgnoreCase("employee")) {
						// add employee object to list
						employees.add(employee);
					} else if (tagname.equalsIgnoreCase("id")) {
						employee.setId(Integer.parseInt(text));
					} else if (tagname.equalsIgnoreCase("name")) {
						employee.setName(text);
					} else if (tagname.equalsIgnoreCase("salary")) {
						employee.setSalary(Float.parseFloat(text));
					}
					break;

				default:
					break;
				}
				eventType = parser.next();
			}

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return employees;
	}
}