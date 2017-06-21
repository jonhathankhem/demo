package com.kj.connect;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class DBConnection {

	public static Connection getConnection(String RefNo,String env,String schema) throws Exception {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		
			fis = new FileInputStream("C:\\Users\\AK Jain\\Desktop\\db.properties");
			props.load(fis);

			// load the Driver Class
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			System.out.println(props.getProperty("DB_DRIVER_CLASS"));
			System.out.println(props.getProperty("DB_URL"));
			System.out.println(props.getProperty("DB_USERNAME"));
			System.out.println(props.getProperty("DB_PASSWORD"));
			// create the connection now
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		
		return con;
	}
	
	
	public static String format(String xml) throws IOException, SAXException, ParserConfigurationException {
		 
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xml)));
		 
		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		format.setIndent(2);
		format.setOmitXMLDeclaration(true);
		format.setLineWidth(Integer.MAX_VALUE);
		Writer outxml = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(outxml, format);
		serializer.serialize(doc);
		 
		return outxml.toString();
		 
		}
	
}