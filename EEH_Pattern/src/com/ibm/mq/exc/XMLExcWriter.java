package com.ibm.mq.exc;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultElement;
import org.xml.sax.SAXException;

public class XMLExcWriter {

	private static String dbName = patternutil.workCatalog.getAbsolutePath();
	private static SAXReader reader = null;
	private static Document document = null;
	private static Element root = null;
	private static String JAVA_MAP_MASTER = "samp/exccat/ExcCat.EEH_Master_JavaMap.xml";
	public static Integer HIGHEST_VALUE = 90000;

	public static void initialize(String file) {
		reader = new SAXReader();
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root = document.getRootElement();
	}

	/**
	 * Writes an exception and various info about it to an xml file Should be
	 * expanded upon to simply add on to existing xml file rather than overwrite
	 * 
	 * @param strException
	 * @param intLineNumber
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void write(String strException, ArrayList<Parameter> paramList, Boolean javaMap)
			throws IOException, DocumentException, ParserConfigurationException, SAXException {
		/*
		 * If javaMap is true, initialize the document with the ExcCat.EEH_Master_JavaMap.xml
		 * Else, initialize the document with the ExcCat.<AppId>.xml
		 */
		if(javaMap){
			initialize(JAVA_MAP_MASTER);
		} else {
			initialize(patternutil.workCatalog.getAbsolutePath());
		}
		// Iterators to search for all nodes, including comments
		Iterator<?> i = root.nodeIterator();
		Iterator<?> j = root.nodeIterator();
		while (i.hasNext()) {
			Node currNode = (Node) i.next();
			Node nextNode = (Node) j.next();

			// Is the current node a comment?
			if (currNode.getText().contains("EXCEPTION CATAGORY = 01 => Operating System Related")) {
				j.next();
				nextNode = (Node) j.next();

				DefaultElement exception = new DefaultElement("Exception");
				exception.addAttribute("name", strException);
				if(javaMap){
					exception.addAttribute("class", "TODO: Add correct import path");
					for (Parameter param : paramList) {
						exception.addElement("Parameter").addAttribute("name", param.getName()).addAttribute("member", param.getMember()).addAttribute("type", param.getType());
					}
				} else {
					exception.addAttribute("priority", "1");
					exception.addAttribute("descr", "");
					HIGHEST_VALUE ++;
					exception.addAttribute("code", HIGHEST_VALUE.toString());
					for (Parameter param : paramList) {
						// <Parameter name="Key" descr="The key looked for in the environment variable."/>
						exception.addElement("Parameter").addAttribute("name", param.getName()).addAttribute("descr", param.getDescr());
					}
				}

				// Get the first element in the list
				List<Node> elements = currNode.getParent().elements();

				// Make a copy of the current comment node being looked at,
				// and remove it
				Node copy = (Node) currNode.clone();
				currNode.detach();
				// Create the start Todo comment node
				Node endOfComment = (Node) copy.clone();
				endOfComment.setText("END: EEH Engineered");
				// Create the end Todo comment node
				Node startOfComment = (Node) copy.clone();
				startOfComment.setText("TODO: EEH Engineered ");

				// Insert the exception element, and before the new element
				elements.add(elements.indexOf(nextNode), endOfComment);
				// Reinsert the existing comment node
				elements.add(elements.indexOf(endOfComment), exception);
				elements.add(elements.indexOf(exception), startOfComment);
				elements.add(elements.indexOf(nextNode), copy);
				break;
			}
		}

		String writeTo = dbName;
		if(javaMap){
			writeTo = JAVA_MAP_MASTER;
		}
		XMLWriter writer = new XMLWriter(new FileWriter(writeTo));
		OutputFormat format = OutputFormat.createPrettyPrint();
		writer = new XMLWriter(new FileOutputStream(writeTo), format);
		writer.write(document);
		writer.close();

	}

	/**
	 * TODO: ADD COMMENTS
	 * 
	 * @param strException
	 * @return
	 * @throws DocumentException
	 */
	public static boolean exceptionExist(String strException, Boolean javaMap) throws DocumentException {
		if(javaMap){
			initialize(JAVA_MAP_MASTER);
		} else {
			initialize(patternutil.workCatalog.getAbsolutePath());
		}
		Iterator<?> i = root.elementIterator();
		boolean boolExist = false;

		while (i.hasNext()) {
			Element child = (Element) i.next();
			if(child.attribute("name") == null){
				break;
			}
			// Check to see if the exception already exists in the file
			if (child.attributeValue("name").equalsIgnoreCase(strException)) {
				boolExist = true;
			}

		}

		return boolExist;
	}

	/**
	 * Find the parameters attached to a specific exception
	 * Only for use with JavaMap.xml 
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getParams(String strException) {
		initialize(JAVA_MAP_MASTER);
		List <String> strArray = new ArrayList<String>();
		List<Node> nodes = document.selectNodes("/exc:ExceptionCatalog/Exception[@name='" + strException + "']/Parameter");
		for(Node node : nodes) {
			Element element = (Element) node;
			strArray.add((String) element.attributeValue("member"));
		}
		return strArray;
	}

	/**
	 * A catalog has been copied from ExcCat.EEH_Master.xml to ExcCat.<App>.xml
	 * change name: from ExcCat.EEH_Master to ExcCat.TEST change appid: form
	 * EEH_Master to TEST
	 * 
	 * @throws DocumentException
	 */
	public static void updateCatalogParams(String strFile, String strApp) {
		initialize(patternutil.workCatalog.getAbsolutePath());
		root.attribute("name").setText("ExcCat." + strApp);

		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileWriter(strFile));
			OutputFormat format = OutputFormat.createPrettyPrint();
			writer = new XMLWriter(new FileOutputStream(strFile), format);
			writer.write(document);
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Gets the highest code value
	 */
	public static void getHighestCode() {

		initialize(patternutil.workCatalog.getAbsolutePath());

		List<Node> nodes = document.selectNodes("/exc:ExceptionCatalog/Exception");
		for(Node node : nodes) {
			Element element = (Element) node;
			int intExcCode = Integer.parseInt(element.attributeValue("code").toString());
			if(intExcCode >= 91000) {
				break;
			} else {
				if(intExcCode > HIGHEST_VALUE) {
					HIGHEST_VALUE = intExcCode;
				}
			}
		}
	}

}
