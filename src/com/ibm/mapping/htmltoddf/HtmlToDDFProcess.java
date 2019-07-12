package com.ibm.mapping.htmltoddf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * Servlet implementation class HtmlToDDFProcess
 */
@WebServlet("/HtmlToDDFProcess")
@MultipartConfig(maxFileSize = 16177215)
public class HtmlToDDFProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtmlToDDFProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
		InputStream inputStream = null;
		Part filePart = request.getPart("file");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}
		
		//File input = new File(request.getParameter("file"));
    	/*Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
    	Elements elements = doc.body().select("*");
    	for (Element element : elements) {
    		System.out.println(element);
    	} */
    	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    	Document doc = docBuilder.parse(inputStream);
    	doc.getDocumentElement().normalize();
    	NodeList bodyTag = doc.getElementsByTagName("BODY");
    	Node body = null;
    	for (int i = 0; i < bodyTag.getLength(); i++) {
    		body = bodyTag.item(i);
    	}
    	NodeList nodeList = body.getChildNodes();
    	
    	
    	DocumentBuilderFactory docFactory1 = DocumentBuilderFactory.newInstance();
    	DocumentBuilder docBuilder1 = docFactory1.newDocumentBuilder();
    	Document doc1 = docBuilder1.newDocument();
    	
    	
    	Text doctypeGentranddf = doc1.createTextNode("!DOCTYPE GENTRANDDF");
    	//doc1.appendChild(doctypeGentranddf);
    	
    	
    	Element rootElement = doc1.createElement("GENTRANDDF");
    	doc1.appendChild(rootElement);
    	Attr attr1 = doc1.createAttribute("VERSION");

		attr1.setValue("1.0");

		rootElement.setAttributeNode(attr1);
		
		
		//EXTENDEDRULELIBRARIES elements

		Element extrule = doc1.createElement("EXTENDEDRULELIBRARIES");
		rootElement.appendChild(extrule);


		// XMLFILE elements
				
		Element xmlfile = doc1.createElement("XMLFILE");
		rootElement.appendChild(xmlfile);
		
		// set attribute to XMLFILE element
		
		Attr attr2 = doc1.createAttribute("NAME");

		attr2.setValue("OUTPUT");

		xmlfile.setAttributeNode(attr2);
		
		
		Attr attr3 = doc1.createAttribute("DESCRIPTION");

		attr3.setValue("");

		xmlfile.setAttributeNode(attr3);
		
		
		Attr attr4 = doc1.createAttribute("NOTE");

		attr4.setValue("");

		xmlfile.setAttributeNode(attr4);
		
		
		Attr attr5 = doc1.createAttribute("ACTIVE");

		attr5.setValue("yes");

		xmlfile.setAttributeNode(attr5);
		
		
		Attr attr6 = doc1.createAttribute("XMLTAG");

		attr6.setValue("HTML");

		xmlfile.setAttributeNode(attr6);

		
		Attr attr7 = doc1.createAttribute("NAMESPACES");

		attr7.setValue("no");

		xmlfile.setAttributeNode(attr7);
		
		
		Attr attr8 = doc1.createAttribute("USEPARENTNS");

		attr8.setValue("no");

		xmlfile.setAttributeNode(attr8);
		
		
		Attr attr9 = doc1.createAttribute("NAMESPACE");

		attr9.setValue("");

		xmlfile.setAttributeNode(attr9);
		
		
		Attr attr10 = doc1.createAttribute("OUTPUT_FORMAT");

		attr10.setValue("newlines");

		xmlfile.setAttributeNode(attr10);
		
		
		Attr attr11 = doc1.createAttribute("OUTPUT_HEADER");

		attr11.setValue("no_header");

		xmlfile.setAttributeNode(attr11);
		
		
		Attr attr12 = doc1.createAttribute("ENCODING");

		attr12.setValue("");

		xmlfile.setAttributeNode(attr12);
		
		
		Attr attr13 = doc1.createAttribute("USE_CHAR_ENTITY_REF");

		attr13.setValue("yes");

		xmlfile.setAttributeNode(attr13);
		
		
		Attr attr14 = doc1.createAttribute("DECIMALPOINT");

		attr14.setValue("0x2e");

		xmlfile.setAttributeNode(attr14);
		
		
		Attr attr15 = doc1.createAttribute("ALLOWEMPTYMANDATORYSEQUENCES");

		attr15.setValue("no");

		xmlfile.setAttributeNode(attr15);
		
		
		Attr attr16 = doc1.createAttribute("TRIMPCDATA");

		attr16.setValue("0x02");

		xmlfile.setAttributeNode(attr16);
    
		Element xmlelementbody1 = doc1.createElement("XMLELEMENT");
		xmlfile.appendChild(xmlelementbody1);
		
		// set attribute to XMLELEMENT element
		
		Attr attr_body_24 = doc1.createAttribute("ALLOWANY");

		attr_body_24.setValue("no");

		xmlelementbody1.setAttributeNode(attr_body_24);
		
		
		Attr attr_body_25 = doc1.createAttribute("NAME");

		attr_body_25.setValue("HEAD");

		xmlelementbody1.setAttributeNode(attr_body_25);
		
		
		Attr attr_body_26 = doc1.createAttribute("DESCRIPTION");

		attr_body_26.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_26);

		
		Attr attr_body_27 = doc1.createAttribute("NOTE");

		attr_body_27.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_27);
		
		
		Attr attr_body_28 = doc1.createAttribute("ACTIVE");

		attr_body_28.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_28);
		
		
		
		Attr attr_body_29 = doc1.createAttribute("MINLOOP");

		attr_body_29.setValue("0");

		xmlelementbody1.setAttributeNode(attr_body_29);
		
		
		Attr attr_body_30 = doc1.createAttribute("MAXLOOP");

		attr_body_30.setValue("1");

		xmlelementbody1.setAttributeNode(attr_body_30);
		
		
		Attr attr_body_31 = doc1.createAttribute("XMLTAG");

		attr_body_31.setValue("HEAD");

		xmlelementbody1.setAttributeNode(attr_body_31);
		
		
		Attr attr_body_32 = doc1.createAttribute("USEPARENTNS");

		attr_body_32.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_32);
		
		Element dumdum = xmlelementbody1;
		
		xmlelementbody1 = doc1.createElement("XMLELEMENT");
		dumdum.appendChild(xmlelementbody1);
		
		// set attribute to XMLELEMENT element
		
		attr_body_24 = doc1.createAttribute("ALLOWANY");

		attr_body_24.setValue("no");

		xmlelementbody1.setAttributeNode(attr_body_24);
		
		
		attr_body_25 = doc1.createAttribute("NAME");

		attr_body_25.setValue("STYLE2");

		xmlelementbody1.setAttributeNode(attr_body_25);
		
		
		attr_body_26 = doc1.createAttribute("DESCRIPTION");

		attr_body_26.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_26);

		
		attr_body_27 = doc1.createAttribute("NOTE");

		attr_body_27.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_27);
		
		
		attr_body_28 = doc1.createAttribute("ACTIVE");

		attr_body_28.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_28);
		
		
		
		attr_body_29 = doc1.createAttribute("MINLOOP");

		attr_body_29.setValue("0");

		xmlelementbody1.setAttributeNode(attr_body_29);
		
		
		attr_body_30 = doc1.createAttribute("MAXLOOP");

		attr_body_30.setValue("1");

		xmlelementbody1.setAttributeNode(attr_body_30);
		
		
		attr_body_31 = doc1.createAttribute("XMLTAG");

		attr_body_31.setValue("STYLE2");

		xmlelementbody1.setAttributeNode(attr_body_31);
		
		
		attr_body_32 = doc1.createAttribute("USEPARENTNS");

		attr_body_32.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_32);
		
		Element xml_rec5_body = doc1.createElement("XMLRECORD");
		
		xmlelementbody1.appendChild(xml_rec5_body);
		
		// set attr1_body_r2ibute to XMLRECORD element		
		
		Attr attr1_body_r1 = doc1.createAttribute("NAME");

		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

		xml_rec5_body.setAttributeNode(attr1_body_r1);
		
		
		Attr attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

		attr1_body_r2.setValue("");

		xml_rec5_body.setAttributeNode(attr1_body_r2);

		
		Attr attr1_body_r3 = doc1.createAttribute("NOTE");

		attr1_body_r3.setValue("");

		xml_rec5_body.setAttributeNode(attr1_body_r3);
		
		
		Attr attr1_body_r4 = doc1.createAttribute("ACTIVE");

		attr1_body_r4.setValue("yes");

		xml_rec5_body.setAttributeNode(attr1_body_r4);
		
		
		
		Attr attr1_body_r5 = doc1.createAttribute("MINLOOP");

		attr1_body_r5.setValue("0");

		xml_rec5_body.setAttributeNode(attr1_body_r5);
		
		
		Attr attr1_body_r6 = doc1.createAttribute("MAXLOOP");

		attr1_body_r6.setValue("1");

		xml_rec5_body.setAttributeNode(attr1_body_r6);
		
		
		Attr attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

		attr1_body_r7.setValue("normal");

		xml_rec5_body.setAttributeNode(attr1_body_r7);
		
		
		Attr attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

		attr1_body_r8.setValue("");

		xml_rec5_body.setAttributeNode(attr1_body_r8);
		
		
		Attr attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

		attr1_body_r9.setValue("pcdata");

		xml_rec5_body.setAttributeNode(attr1_body_r9);
		
		
		Attr attr1_body_r10 = doc1.createAttribute("FLOATING");

		attr1_body_r10.setValue("no");

		xml_rec5_body.setAttributeNode(attr1_body_r10);
		
		Element xmlpcd = doc1.createElement("XMLPCDATA");
		xml_rec5_body.appendChild(xmlpcd);
		
		// set attribute to XMLPCDATA element		
		
		Attr attr90 = doc1.createAttribute("NAME");

		attr90.setValue("STYLE2");

		xmlpcd.setAttributeNode(attr90);
		
		
		Attr attr91 = doc1.createAttribute("DESCRIPTION");

		attr91.setValue("");

		xmlpcd.setAttributeNode(attr91);

		
		Attr attr92 = doc1.createAttribute("NOTE");

		attr92.setValue("");

		xmlpcd.setAttributeNode(attr92);
		
		
		Attr attr93 = doc1.createAttribute("ACTIVE");

		attr93.setValue("yes");

		xmlpcd.setAttributeNode(attr93);
		
		
		
		Attr attr94 = doc1.createAttribute("MANDATORY");

		attr94.setValue("no");

		xmlpcd.setAttributeNode(attr94);
		
		
		Attr attr95 = doc1.createAttribute("NOTUSED");

		attr95.setValue("no");

		xmlpcd.setAttributeNode(attr95);
		
		
		Attr attr96 = doc1.createAttribute("MINDATALEN");

		attr96.setValue("0");

		xmlpcd.setAttributeNode(attr96);
		
		
		Attr attr97 = doc1.createAttribute("MAXDATALEN");

		attr97.setValue("2000");

		xmlpcd.setAttributeNode(attr97);
		
		
		Attr attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

		attr98.setValue("1");

		xmlpcd.setAttributeNode(attr98);
		
		
		Attr attr99 = doc1.createAttribute("TYPE");

		attr99.setValue("string");

		xmlpcd.setAttributeNode(attr99);
		
		
		Attr attr100 = doc1.createAttribute("FORMAT");

		attr100.setValue("");

		xmlpcd.setAttributeNode(attr100);
		
		
		xmlelementbody1 = doc1.createElement("XMLELEMENT");
		xmlfile.appendChild(xmlelementbody1);
		
		// set attribute to XMLELEMENT element
		
		attr_body_24 = doc1.createAttribute("ALLOWANY");

		attr_body_24.setValue("no");

		xmlelementbody1.setAttributeNode(attr_body_24);
		
		
		attr_body_25 = doc1.createAttribute("NAME");

		attr_body_25.setValue("BODY");

		xmlelementbody1.setAttributeNode(attr_body_25);
		
		
		attr_body_26 = doc1.createAttribute("DESCRIPTION");

		attr_body_26.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_26);

		
		attr_body_27 = doc1.createAttribute("NOTE");

		attr_body_27.setValue("");

		xmlelementbody1.setAttributeNode(attr_body_27);
		
		
		attr_body_28 = doc1.createAttribute("ACTIVE");

		attr_body_28.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_28);
		
		
		
		attr_body_29 = doc1.createAttribute("MINLOOP");

		attr_body_29.setValue("0");

		xmlelementbody1.setAttributeNode(attr_body_29);
		
		
		attr_body_30 = doc1.createAttribute("MAXLOOP");

		attr_body_30.setValue("1");

		xmlelementbody1.setAttributeNode(attr_body_30);
		
		
		attr_body_31 = doc1.createAttribute("XMLTAG");

		attr_body_31.setValue("BODY");

		xmlelementbody1.setAttributeNode(attr_body_31);
		
		
		attr_body_32 = doc1.createAttribute("USEPARENTNS");

		attr_body_32.setValue("yes");

		xmlelementbody1.setAttributeNode(attr_body_32);
		
		
		
		
		
	
		// XMLELEMENT under XMLELEMENT for HR:15 elements
		
		for (int i = 0; i < nodeList.getLength(); i++) {
    	
			if (nodeList.item(i).getNodeName().equals("#text")) {
				continue;
			}
			
			
    		
    	Element xmlelement2body1 = doc1.createElement("XMLELEMENT");
		xmlelementbody1.appendChild(xmlelement2body1);
		
		// set attr_body_ibute to XMLELEMENT element
		
		Attr attr_body_33 = doc1.createAttribute("ALLOWANY");

		attr_body_33.setValue("no");

		xmlelement2body1.setAttributeNode(attr_body_33);
		
		
		Attr attr_body_34 = doc1.createAttribute("NAME");

		 attr_body_34.setValue(nodeList.item(i).getNodeName() + ":" + i);
		
		xmlelement2body1.setAttributeNode(attr_body_34);
		
		
		Attr attr_body_35 = doc1.createAttribute("DESCRIPTION");

		attr_body_35.setValue("");

		xmlelement2body1.setAttributeNode(attr_body_35);

		
		Attr attr_body_36 = doc1.createAttribute("NOTE");

		attr_body_36.setValue("");

		xmlelement2body1.setAttributeNode(attr_body_36);
		
		
		Attr attr_body_37 = doc1.createAttribute("ACTIVE");

		attr_body_37.setValue("yes");

		xmlelement2body1.setAttributeNode(attr_body_37);
		
		
		
		Attr attr_body_38 = doc1.createAttribute("MINLOOP");

		attr_body_38.setValue("0");

		xmlelement2body1.setAttributeNode(attr_body_38);
		
		
		Attr attr_body_39 = doc1.createAttribute("MAXLOOP");

		attr_body_39.setValue("1");

		xmlelement2body1.setAttributeNode(attr_body_39);
		
		
		Attr attr_body_40 = doc1.createAttribute("XMLTAG");

		attr_body_40.setValue(nodeList.item(i).getNodeName());

		xmlelement2body1.setAttributeNode(attr_body_40);
		
		
		Attr attr_body_41 = doc1.createAttribute("USEPARENTNS");

		attr_body_41.setValue("yes");

		xmlelement2body1.setAttributeNode(attr_body_41);
		
		
		
		if (nodeList.item(i).getNodeName().equals("BR") || nodeList.item(i).getNodeName().equals("HR")) {
			
			xml_rec5_body = doc1.createElement("XMLRECORD");
    		
    		xmlelement2body1.appendChild(xml_rec5_body);
    		
    		// set attr1_body_r2ibute to XMLRECORD element		
    		
    		attr1_body_r1 = doc1.createAttribute("NAME");

    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

    		xml_rec5_body.setAttributeNode(attr1_body_r1);
    		
    		
    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

    		attr1_body_r2.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r2);

    		
    		attr1_body_r3 = doc1.createAttribute("NOTE");

    		attr1_body_r3.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r3);
    		
    		
    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

    		attr1_body_r4.setValue("yes");

    		xml_rec5_body.setAttributeNode(attr1_body_r4);
    		
    		
    		
    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

    		attr1_body_r5.setValue("0");

    		xml_rec5_body.setAttributeNode(attr1_body_r5);
    		
    		
    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

    		attr1_body_r6.setValue("1");

    		xml_rec5_body.setAttributeNode(attr1_body_r6);
    		
    		
    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

    		attr1_body_r7.setValue("normal");

    		xml_rec5_body.setAttributeNode(attr1_body_r7);
    		
    		
    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

    		attr1_body_r8.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r8);
    		
    		
    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

    		attr1_body_r9.setValue("pcdata");

    		xml_rec5_body.setAttributeNode(attr1_body_r9);
    		
    		
    		attr1_body_r10 = doc1.createAttribute("FLOATING");

    		attr1_body_r10.setValue("no");

    		xml_rec5_body.setAttributeNode(attr1_body_r10);
			
			
			
			
			xmlpcd = doc1.createElement("XMLPCDATA");
			xml_rec5_body.appendChild(xmlpcd);
			
			// set attribute to XMLPCDATA element		
			
			attr90 = doc1.createAttribute("NAME");

			attr90.setValue("STYLE2");

			xmlpcd.setAttributeNode(attr90);
			
			
			attr91 = doc1.createAttribute("DESCRIPTION");

			attr91.setValue("");

			xmlpcd.setAttributeNode(attr91);

			
			attr92 = doc1.createAttribute("NOTE");

			attr92.setValue("");

			xmlpcd.setAttributeNode(attr92);
			
			
			attr93 = doc1.createAttribute("ACTIVE");

			attr93.setValue("yes");

			xmlpcd.setAttributeNode(attr93);
			
			
			
			attr94 = doc1.createAttribute("MANDATORY");

			attr94.setValue("no");

			xmlpcd.setAttributeNode(attr94);
			
			
			attr95 = doc1.createAttribute("NOTUSED");

			attr95.setValue("no");

			xmlpcd.setAttributeNode(attr95);
			
			
			attr96 = doc1.createAttribute("MINDATALEN");

			attr96.setValue("0");

			xmlpcd.setAttributeNode(attr96);
			
			
			attr97 = doc1.createAttribute("MAXDATALEN");

			attr97.setValue("2000");

			xmlpcd.setAttributeNode(attr97);
			
			
			attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

			attr98.setValue("1");

			xmlpcd.setAttributeNode(attr98);
			
			
			attr99 = doc1.createAttribute("TYPE");

			attr99.setValue("string");

			xmlpcd.setAttributeNode(attr99);
			
			
			attr100 = doc1.createAttribute("FORMAT");

			attr100.setValue("");

			xmlpcd.setAttributeNode(attr100); 
		}
		else {
			
			    			
			xml_rec5_body = doc1.createElement("XMLRECORD");
    		
    		xmlelement2body1.appendChild(xml_rec5_body);
    		
    		// set attr1_body_r2ibute to XMLRECORD element		
    		
    		attr1_body_r1 = doc1.createAttribute("NAME");

    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

    		xml_rec5_body.setAttributeNode(attr1_body_r1);
    		
    		
    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

    		attr1_body_r2.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r2);

    		
    		attr1_body_r3 = doc1.createAttribute("NOTE");

    		attr1_body_r3.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r3);
    		
    		
    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

    		attr1_body_r4.setValue("yes");

    		xml_rec5_body.setAttributeNode(attr1_body_r4);
    		
    		
    		
    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

    		attr1_body_r5.setValue("0");

    		xml_rec5_body.setAttributeNode(attr1_body_r5);
    		
    		
    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

    		attr1_body_r6.setValue("1");

    		xml_rec5_body.setAttributeNode(attr1_body_r6);
    		
    		
    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

    		attr1_body_r7.setValue("normal");

    		xml_rec5_body.setAttributeNode(attr1_body_r7);
    		
    		
    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

    		attr1_body_r8.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r8);
    		
    		
    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

    		attr1_body_r9.setValue("attribute");

    		xml_rec5_body.setAttributeNode(attr1_body_r9);
    		
    		
    		attr1_body_r10 = doc1.createAttribute("FLOATING");

    		attr1_body_r10.setValue("no");

    		xml_rec5_body.setAttributeNode(attr1_body_r10);
			
			
		Element xml_body_attr12_body_1 = doc1.createElement("XMLATTR");
		xml_rec5_body.appendChild(xml_body_attr12_body_1);
		
		// set attr2_body_1ibute to XMLATTR element		
		
		Attr attr2_body_155 = doc1.createAttribute("NAME");

		attr2_body_155.setValue("CLASSGH:613");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_155);
		
		
		Attr attr2_body_156 = doc1.createAttribute("DESCRIPTION");

		attr2_body_156.setValue("");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_156);

		
		Attr attr2_body_157 = doc1.createAttribute("NOTE");

		attr2_body_157.setValue("");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_157);
		
		
		Attr attr2_body_158 = doc1.createAttribute("ACTIVE");

		attr2_body_158.setValue("yes");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_158);
		
		
		
		Attr attr2_body_159 = doc1.createAttribute("MANDATORY");

		attr2_body_159.setValue("no");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_159);
		
		
		Attr attr2_body_160 = doc1.createAttribute("NOTUSED");

		attr2_body_160.setValue("no");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_160);
		
		
		Attr attr2_body_161 = doc1.createAttribute("MINDATALEN");

		attr2_body_161.setValue("0");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_161);
		
		
		Attr attr2_body_162 = doc1.createAttribute("MAXDATALEN");

		attr2_body_162.setValue("20");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_162);
		
		
		Attr attr2_body_163 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

		attr2_body_163.setValue("1");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_163);
		
		
		Attr attr2_body_164 = doc1.createAttribute("TYPE");

		attr2_body_164.setValue("string");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_164);
		
		
		Attr attr2_body_165 = doc1.createAttribute("FORMAT");

		attr2_body_165.setValue("");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_165);
		
		
		Attr attr2_body_166 = doc1.createAttribute("XMLTAG");

		attr2_body_166.setValue("CLASS");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_166);
		
		
		Attr attr2_body_167 = doc1.createAttribute("USEPARENTNS");

		attr2_body_167.setValue("no");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_167);
		
		
		Attr attr2_body_168 = doc1.createAttribute("NAMESPACE");

		attr2_body_168.setValue("");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_168);
		
		
		Attr attr2_body_169 = doc1.createAttribute("ATTRTYPE");

		attr2_body_169.setValue("CDATA");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_169);
		
		
		Attr attr2_body_170 = doc1.createAttribute("ATTRBEHAVIOR");

		attr2_body_170.setValue("IMPLIED");

		xml_body_attr12_body_1.setAttributeNode(attr2_body_170);

		
		// XMLATTR elements
		
		Element xml_body_attr32_body_1 = doc1.createElement("XMLATTR");
		xml_rec5_body.appendChild(xml_body_attr32_body_1);
		
		// set attr2_body_2ibute to XMLATTR element		
		
		Attr attr2_body_255 = doc1.createAttribute("NAME");

		attr2_body_255.setValue("WIDTH:470");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_255);
		
		
		Attr attr2_body_256 = doc1.createAttribute("DESCRIPTION");

		attr2_body_256.setValue("");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_256);

		
		Attr attr2_body_257 = doc1.createAttribute("NOTE");

		attr2_body_257.setValue("");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_257);
		
		
		Attr attr2_body_258 = doc1.createAttribute("ACTIVE");

		attr2_body_258.setValue("yes");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_258);
		
		
		
		Attr attr2_body_259 = doc1.createAttribute("MANDATORY");

		attr2_body_259.setValue("no");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_259);
		
		
		Attr attr2_body_260 = doc1.createAttribute("NOTUSED");

		attr2_body_260.setValue("no");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_260);
		
		
		Attr attr2_body_261 = doc1.createAttribute("MINDATALEN");

		attr2_body_261.setValue("0");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_261);
		
		
		Attr attr2_body_262 = doc1.createAttribute("MAXDATALEN");

		attr2_body_262.setValue("20");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_262);
		
		
		Attr attr2_body_263 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

		attr2_body_263.setValue("1");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_263);
		
		
		Attr attr2_body_264 = doc1.createAttribute("TYPE");

		attr2_body_264.setValue("string");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_264);
		
		
		Attr attr2_body_265 = doc1.createAttribute("FORMAT");

		attr2_body_265.setValue("");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_265);
		
		
		Attr attr2_body_266 = doc1.createAttribute("XMLTAG");

		attr2_body_266.setValue("WIDTH");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_266);
		
		
		Attr attr2_body_267 = doc1.createAttribute("USEPARENTNS");

		attr2_body_267.setValue("no");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_267);
		
		
		Attr attr2_body_268 = doc1.createAttribute("NAMESPACE");

		attr2_body_268.setValue("");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_268);
		
		
		Attr attr2_body_269 = doc1.createAttribute("ATTRTYPE");

		attr2_body_269.setValue("CDATA");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_269);
		
		
		Attr attr2_body_270 = doc1.createAttribute("ATTRBEHAVIOR");

		attr2_body_270.setValue("IMPLIED");

		xml_body_attr32_body_1.setAttributeNode(attr2_body_270);
		
		if (nodeList.item(i).getNodeName().equals("DIV")) {
			xml_rec5_body = doc1.createElement("XMLRECORD");
    		
    		xmlelement2body1.appendChild(xml_rec5_body);
    		
    		// set attr1_body_r2ibute to XMLRECORD element		
    		
    		attr1_body_r1 = doc1.createAttribute("NAME");

    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

    		xml_rec5_body.setAttributeNode(attr1_body_r1);
    		
    		
    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

    		attr1_body_r2.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r2);

    		
    		attr1_body_r3 = doc1.createAttribute("NOTE");

    		attr1_body_r3.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r3);
    		
    		
    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

    		attr1_body_r4.setValue("yes");

    		xml_rec5_body.setAttributeNode(attr1_body_r4);
    		
    		
    		
    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

    		attr1_body_r5.setValue("0");

    		xml_rec5_body.setAttributeNode(attr1_body_r5);
    		
    		
    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

    		attr1_body_r6.setValue("1");

    		xml_rec5_body.setAttributeNode(attr1_body_r6);
    		
    		
    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

    		attr1_body_r7.setValue("normal");

    		xml_rec5_body.setAttributeNode(attr1_body_r7);
    		
    		
    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

    		attr1_body_r8.setValue("");

    		xml_rec5_body.setAttributeNode(attr1_body_r8);
    		
    		
    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

    		attr1_body_r9.setValue("pcdata");

    		xml_rec5_body.setAttributeNode(attr1_body_r9);
    		
    		
    		attr1_body_r10 = doc1.createAttribute("FLOATING");

    		attr1_body_r10.setValue("no");

    		xml_rec5_body.setAttributeNode(attr1_body_r10);
    		
    		xmlpcd = doc1.createElement("XMLPCDATA");
			xml_rec5_body.appendChild(xmlpcd);
			
			// set attribute to XMLPCDATA element		
			
			attr90 = doc1.createAttribute("NAME");

			attr90.setValue("STYLE2");

			xmlpcd.setAttributeNode(attr90);
			
			
			attr91 = doc1.createAttribute("DESCRIPTION");

			attr91.setValue("");

			xmlpcd.setAttributeNode(attr91);

			
			attr92 = doc1.createAttribute("NOTE");

			attr92.setValue("");

			xmlpcd.setAttributeNode(attr92);
			
			
			attr93 = doc1.createAttribute("ACTIVE");

			attr93.setValue("yes");

			xmlpcd.setAttributeNode(attr93);
			
			
			
			attr94 = doc1.createAttribute("MANDATORY");

			attr94.setValue("no");

			xmlpcd.setAttributeNode(attr94);
			
			
			attr95 = doc1.createAttribute("NOTUSED");

			attr95.setValue("no");

			xmlpcd.setAttributeNode(attr95);
			
			
			attr96 = doc1.createAttribute("MINDATALEN");

			attr96.setValue("0");

			xmlpcd.setAttributeNode(attr96);
			
			
			attr97 = doc1.createAttribute("MAXDATALEN");

			attr97.setValue("2000");

			xmlpcd.setAttributeNode(attr97);
			
			
			attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

			attr98.setValue("1");

			xmlpcd.setAttributeNode(attr98);
			
			
			attr99 = doc1.createAttribute("TYPE");

			attr99.setValue("string");

			xmlpcd.setAttributeNode(attr99);
			
			
			attr100 = doc1.createAttribute("FORMAT");

			attr100.setValue("");

			xmlpcd.setAttributeNode(attr100);
		}
		
		}
		  		
		NodeList dummy = nodeList.item(i).getChildNodes();
		if (nodeList.item(i).getNodeName().equals("TABLE") || nodeList.item(i).getNodeName().equals("Table")) {
			for (int j = 0; j < dummy.getLength(); j++) {
				//System.out.println(dummy.item(j).getNodeName());
				
				if (dummy.item(j).getNodeName().equals("#text")) {
					continue;
				}
				
				
				Element xmlelement3body1 = doc1.createElement("XMLELEMENT");
	    		xmlelement2body1.appendChild(xmlelement3body1);
	    		
	    		// set attr_body_ibute to XMLELEMENT element
	    		
	    		Attr attr_body_56 = doc1.createAttribute("ALLOWANY");

	    		attr_body_56.setValue("no");

	    		xmlelement3body1.setAttributeNode(attr_body_56);
	    		
	    		
	    		Attr attr_body_57 = doc1.createAttribute("NAME");

	    		 attr_body_57.setValue(dummy.item(j).getNodeName() + ":" + j);
	    		
	    		xmlelement3body1.setAttributeNode(attr_body_57);
	    		
	    		
	    		Attr attr_body_58 = doc1.createAttribute("DESCRIPTION");

	    		attr_body_58.setValue("");

	    		xmlelement3body1.setAttributeNode(attr_body_58);

	    		
	    		Attr attr_body_59 = doc1.createAttribute("NOTE");

	    		attr_body_59.setValue("");

	    		xmlelement3body1.setAttributeNode(attr_body_59);
	    		
	    		
	    		Attr attr_body_60 = doc1.createAttribute("ACTIVE");

	    		attr_body_60.setValue("yes");

	    		xmlelement3body1.setAttributeNode(attr_body_60);
	    		
	    		
	    		
	    		Attr attr_body_61 = doc1.createAttribute("MINLOOP");

	    		attr_body_61.setValue("0");

	    		xmlelement3body1.setAttributeNode(attr_body_61);
	    		
	    		
	    		Attr attr_body_62 = doc1.createAttribute("MAXLOOP");

	    		attr_body_62.setValue("1");

	    		xmlelement3body1.setAttributeNode(attr_body_62);
	    		
	    		
	    		Attr attr_body_63 = doc1.createAttribute("XMLTAG");

	    		attr_body_63.setValue(dummy.item(j).getNodeName());

	    		xmlelement3body1.setAttributeNode(attr_body_63);
	    		
	    		
	    		Attr attr_body_64 = doc1.createAttribute("USEPARENTNS");

	    		attr_body_64.setValue("yes");

	    		xmlelement3body1.setAttributeNode(attr_body_64);
	    		
	    		if (dummy.item(j).getNodeName().equals("TABLE")) {
	    			Element xml_rec5_body2 = doc1.createElement("XMLRECORD");
	        		
	        		xmlelement3body1.appendChild(xml_rec5_body2);
	        		
	        		// set attr1_body_r2ibute to XMLRECORD element		
	        		
	        		attr1_body_r1 = doc1.createAttribute("NAME");

	        		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r1);
	        		
	        		
	        		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

	        		attr1_body_r2.setValue("");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r2);

	        		
	        		attr1_body_r3 = doc1.createAttribute("NOTE");

	        		attr1_body_r3.setValue("");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r3);
	        		
	        		
	        		attr1_body_r4 = doc1.createAttribute("ACTIVE");

	        		attr1_body_r4.setValue("yes");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r4);
	        		
	        		
	        		
	        		attr1_body_r5 = doc1.createAttribute("MINLOOP");

	        		attr1_body_r5.setValue("0");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r5);
	        		
	        		
	        		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

	        		attr1_body_r6.setValue("1");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r6);
	        		
	        		
	        		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

	        		attr1_body_r7.setValue("normal");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r7);
	        		
	        		
	        		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

	        		attr1_body_r8.setValue("");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r8);
	        		
	        		
	        		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

	        		attr1_body_r9.setValue("attribute");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r9);
	        		
	        		
	        		attr1_body_r10 = doc1.createAttribute("FLOATING");

	        		attr1_body_r10.setValue("no");

	        		xml_rec5_body2.setAttributeNode(attr1_body_r10);
	        		
	        		Element xml_body_attr12_body_1 = doc1.createElement("XMLATTR");
		    		xml_rec5_body2.appendChild(xml_body_attr12_body_1);
		    		
		    		// set attr2_body_1ibute to XMLATTR element		
		    		
		    		Attr attr2_body_155 = doc1.createAttribute("NAME");

		    		attr2_body_155.setValue("CLASSGH:613");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_155);
		    		
		    		
		    		Attr attr2_body_156 = doc1.createAttribute("DESCRIPTION");

		    		attr2_body_156.setValue("");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_156);

		    		
		    		Attr attr2_body_157 = doc1.createAttribute("NOTE");

		    		attr2_body_157.setValue("");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_157);
		    		
		    		
		    		Attr attr2_body_158 = doc1.createAttribute("ACTIVE");

		    		attr2_body_158.setValue("yes");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_158);
		    		
		    		
		    		
		    		Attr attr2_body_159 = doc1.createAttribute("MANDATORY");

		    		attr2_body_159.setValue("no");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_159);
		    		
		    		
		    		Attr attr2_body_160 = doc1.createAttribute("NOTUSED");

		    		attr2_body_160.setValue("no");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_160);
		    		
		    		
		    		Attr attr2_body_161 = doc1.createAttribute("MINDATALEN");

		    		attr2_body_161.setValue("0");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_161);
		    		
		    		
		    		Attr attr2_body_162 = doc1.createAttribute("MAXDATALEN");

		    		attr2_body_162.setValue("20");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_162);
		    		
		    		
		    		Attr attr2_body_163 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

		    		attr2_body_163.setValue("1");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_163);
		    		
		    		
		    		Attr attr2_body_164 = doc1.createAttribute("TYPE");

		    		attr2_body_164.setValue("string");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_164);
		    		
		    		
		    		Attr attr2_body_165 = doc1.createAttribute("FORMAT");

		    		attr2_body_165.setValue("");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_165);
		    		
		    		
		    		Attr attr2_body_166 = doc1.createAttribute("XMLTAG");

		    		attr2_body_166.setValue("CLASS");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_166);
		    		
		    		
		    		Attr attr2_body_167 = doc1.createAttribute("USEPARENTNS");

		    		attr2_body_167.setValue("no");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_167);
		    		
		    		
		    		Attr attr2_body_168 = doc1.createAttribute("NAMESPACE");

		    		attr2_body_168.setValue("");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_168);
		    		
		    		
		    		Attr attr2_body_169 = doc1.createAttribute("ATTRTYPE");

		    		attr2_body_169.setValue("CDATA");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_169);
		    		
		    		
		    		Attr attr2_body_170 = doc1.createAttribute("ATTRBEHAVIOR");

		    		attr2_body_170.setValue("IMPLIED");

		    		xml_body_attr12_body_1.setAttributeNode(attr2_body_170);

		    		
		    		// XMLATTR elements
		    		
		    		Element xml_body_attr32_body_1 = doc1.createElement("XMLATTR");
		    		xml_rec5_body2.appendChild(xml_body_attr32_body_1);
		    		
		    		// set attr2_body_2ibute to XMLATTR element		
		    		
		    		Attr attr2_body_255 = doc1.createAttribute("NAME");

		    		attr2_body_255.setValue("WIDTH:470");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_255);
		    		
		    		
		    		Attr attr2_body_256 = doc1.createAttribute("DESCRIPTION");

		    		attr2_body_256.setValue("");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_256);

		    		
		    		Attr attr2_body_257 = doc1.createAttribute("NOTE");

		    		attr2_body_257.setValue("");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_257);
		    		
		    		
		    		Attr attr2_body_258 = doc1.createAttribute("ACTIVE");

		    		attr2_body_258.setValue("yes");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_258);
		    		
		    		
		    		
		    		Attr attr2_body_259 = doc1.createAttribute("MANDATORY");

		    		attr2_body_259.setValue("no");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_259);
		    		
		    		
		    		Attr attr2_body_260 = doc1.createAttribute("NOTUSED");

		    		attr2_body_260.setValue("no");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_260);
		    		
		    		
		    		Attr attr2_body_261 = doc1.createAttribute("MINDATALEN");

		    		attr2_body_261.setValue("0");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_261);
		    		
		    		
		    		Attr attr2_body_262 = doc1.createAttribute("MAXDATALEN");

		    		attr2_body_262.setValue("20");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_262);
		    		
		    		
		    		Attr attr2_body_263 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

		    		attr2_body_263.setValue("1");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_263);
		    		
		    		
		    		Attr attr2_body_264 = doc1.createAttribute("TYPE");

		    		attr2_body_264.setValue("string");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_264);
		    		
		    		
		    		Attr attr2_body_265 = doc1.createAttribute("FORMAT");

		    		attr2_body_265.setValue("");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_265);
		    		
		    		
		    		Attr attr2_body_266 = doc1.createAttribute("XMLTAG");

		    		attr2_body_266.setValue("WIDTH");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_266);
		    		
		    		
		    		Attr attr2_body_267 = doc1.createAttribute("USEPARENTNS");

		    		attr2_body_267.setValue("no");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_267);
		    		
		    		
		    		Attr attr2_body_268 = doc1.createAttribute("NAMESPACE");

		    		attr2_body_268.setValue("");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_268);
		    		
		    		
		    		Attr attr2_body_269 = doc1.createAttribute("ATTRTYPE");

		    		attr2_body_269.setValue("CDATA");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_269);
		    		
		    		
		    		Attr attr2_body_270 = doc1.createAttribute("ATTRBEHAVIOR");

		    		attr2_body_270.setValue("IMPLIED");

		    		xml_body_attr32_body_1.setAttributeNode(attr2_body_270);
	    		}
	    		
	    		
	    		if (dummy.item(j).getNodeName().equals("TR") || dummy.item(j).getNodeName().equals("TABLE") 
	    				|| dummy.item(j).getNodeName().equals("tbody") || dummy.item(j).getNodeName().equals("b")
	    				|| dummy.item(j).getNodeName().equals("B") || dummy.item(j).getNodeName().equals("Table") 
	    				|| dummy.item(j).getNodeName().equals("BR")) {
					NodeList dummy1 = dummy.item(j).getChildNodes();
					for (int m = 0; m < dummy1.getLength(); m++) {
						
						if (dummy1.item(m).getNodeName().equals("#text")) {
							continue;
						}
						Element xmlelement4body1 = doc1.createElement("XMLELEMENT");
			    		xmlelement3body1.appendChild(xmlelement4body1);
			    		
			    		
			    		
			    		
			    		
			    		// set attr_body_ibute to XMLELEMENT element
			    		
			    		Attr attr_body_80 = doc1.createAttribute("ALLOWANY");

			    		attr_body_80.setValue("no");

			    		xmlelement4body1.setAttributeNode(attr_body_80);
			    		
			    		
			    		Attr attr_body_81 = doc1.createAttribute("NAME");

			    		 attr_body_81.setValue(dummy1.item(m).getNodeName() + ":" + m);
			    		
			    		xmlelement4body1.setAttributeNode(attr_body_81);
			    		
			    		
			    		Attr attr_body_82 = doc1.createAttribute("DESCRIPTION");

			    		attr_body_82.setValue("");

			    		xmlelement4body1.setAttributeNode(attr_body_82);

			    		
			    		Attr attr_body_83 = doc1.createAttribute("NOTE");

			    		attr_body_83.setValue("");

			    		xmlelement4body1.setAttributeNode(attr_body_83);
			    		
			    		
			    		Attr attr_body_84 = doc1.createAttribute("ACTIVE");

			    		attr_body_84.setValue("yes");

			    		xmlelement4body1.setAttributeNode(attr_body_84);
			    		
			    		
			    		
			    		Attr attr_body_85 = doc1.createAttribute("MINLOOP");

			    		attr_body_85.setValue("0");

			    		xmlelement4body1.setAttributeNode(attr_body_85);
			    		
			    		
			    		Attr attr_body_86 = doc1.createAttribute("MAXLOOP");

			    		attr_body_86.setValue("1");

			    		xmlelement4body1.setAttributeNode(attr_body_86);
			    		
			    		
			    		Attr attr_body_87 = doc1.createAttribute("XMLTAG");

			    		attr_body_87.setValue(dummy1.item(m).getNodeName());

			    		xmlelement4body1.setAttributeNode(attr_body_87);
			    		
			    		
			    		Attr attr_body_88 = doc1.createAttribute("USEPARENTNS");

			    		attr_body_88.setValue("yes");

			    		xmlelement4body1.setAttributeNode(attr_body_88);
			    		
			    		//xmlelement4body1.appendChild(xml_rec5_body);
			    		
			    		if (dummy1.item(m).getNodeName().equals("TD")) {
			    				
		    			   			
		    			
		    			Element xml_rec5_body2 = doc1.createElement("XMLRECORD");
		        		
		        		xmlelement4body1.appendChild(xml_rec5_body2);
		        		
		        		// set attr1_body_r2ibute to XMLRECORD element		
		        		
		        		attr1_body_r1 = doc1.createAttribute("NAME");

		        		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r1);
		        		
		        		
		        		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

		        		attr1_body_r2.setValue("");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r2);

		        		
		        		attr1_body_r3 = doc1.createAttribute("NOTE");

		        		attr1_body_r3.setValue("");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r3);
		        		
		        		
		        		attr1_body_r4 = doc1.createAttribute("ACTIVE");

		        		attr1_body_r4.setValue("yes");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r4);
		        		
		        		
		        		
		        		attr1_body_r5 = doc1.createAttribute("MINLOOP");

		        		attr1_body_r5.setValue("0");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r5);
		        		
		        		
		        		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

		        		attr1_body_r6.setValue("1");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r6);
		        		
		        		
		        		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

		        		attr1_body_r7.setValue("normal");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r7);
		        		
		        		
		        		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

		        		attr1_body_r8.setValue("");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r8);
		        		
		        		
		        		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

		        		attr1_body_r9.setValue("attribute");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r9);
		        		
		        		
		        		attr1_body_r10 = doc1.createAttribute("FLOATING");

		        		attr1_body_r10.setValue("no");

		        		xml_rec5_body2.setAttributeNode(attr1_body_r10);
		        		
		        		Element xml_body_attr12_body_1 = doc1.createElement("XMLATTR");
			    		xml_rec5_body2.appendChild(xml_body_attr12_body_1);
			    		
			    		// set attr2_body_1ibute to XMLATTR element		
			    		
			    		Attr attr2_body_155 = doc1.createAttribute("NAME");

			    		attr2_body_155.setValue("CLASSGH:613");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_155);
			    		
			    		
			    		Attr attr2_body_156 = doc1.createAttribute("DESCRIPTION");

			    		attr2_body_156.setValue("");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_156);

			    		
			    		Attr attr2_body_157 = doc1.createAttribute("NOTE");

			    		attr2_body_157.setValue("");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_157);
			    		
			    		
			    		Attr attr2_body_158 = doc1.createAttribute("ACTIVE");

			    		attr2_body_158.setValue("yes");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_158);
			    		
			    		
			    		
			    		Attr attr2_body_159 = doc1.createAttribute("MANDATORY");

			    		attr2_body_159.setValue("no");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_159);
			    		
			    		
			    		Attr attr2_body_160 = doc1.createAttribute("NOTUSED");

			    		attr2_body_160.setValue("no");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_160);
			    		
			    		
			    		Attr attr2_body_161 = doc1.createAttribute("MINDATALEN");

			    		attr2_body_161.setValue("0");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_161);
			    		
			    		
			    		Attr attr2_body_162 = doc1.createAttribute("MAXDATALEN");

			    		attr2_body_162.setValue("20");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_162);
			    		
			    		
			    		Attr attr2_body_163 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

			    		attr2_body_163.setValue("1");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_163);
			    		
			    		
			    		Attr attr2_body_164 = doc1.createAttribute("TYPE");

			    		attr2_body_164.setValue("string");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_164);
			    		
			    		
			    		Attr attr2_body_165 = doc1.createAttribute("FORMAT");

			    		attr2_body_165.setValue("");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_165);
			    		
			    		
			    		Attr attr2_body_166 = doc1.createAttribute("XMLTAG");

			    		attr2_body_166.setValue("CLASS");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_166);
			    		
			    		
			    		Attr attr2_body_167 = doc1.createAttribute("USEPARENTNS");

			    		attr2_body_167.setValue("no");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_167);
			    		
			    		
			    		Attr attr2_body_168 = doc1.createAttribute("NAMESPACE");

			    		attr2_body_168.setValue("");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_168);
			    		
			    		
			    		Attr attr2_body_169 = doc1.createAttribute("ATTRTYPE");

			    		attr2_body_169.setValue("CDATA");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_169);
			    		
			    		
			    		Attr attr2_body_170 = doc1.createAttribute("ATTRBEHAVIOR");

			    		attr2_body_170.setValue("IMPLIED");

			    		xml_body_attr12_body_1.setAttributeNode(attr2_body_170);

			    		
			    		// XMLATTR elements
			    		
			    		Element xml_body_attr32_body_1 = doc1.createElement("XMLATTR");
			    		xml_rec5_body2.appendChild(xml_body_attr32_body_1);
			    		
			    		// set attr2_body_2ibute to XMLATTR element		
			    		
			    		Attr attr2_body_255 = doc1.createAttribute("NAME");

			    		attr2_body_255.setValue("WIDTH:470");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_255);
			    		
			    		
			    		Attr attr2_body_256 = doc1.createAttribute("DESCRIPTION");

			    		attr2_body_256.setValue("");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_256);

			    		
			    		Attr attr2_body_257 = doc1.createAttribute("NOTE");

			    		attr2_body_257.setValue("");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_257);
			    		
			    		
			    		Attr attr2_body_258 = doc1.createAttribute("ACTIVE");

			    		attr2_body_258.setValue("yes");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_258);
			    		
			    		
			    		
			    		Attr attr2_body_259 = doc1.createAttribute("MANDATORY");

			    		attr2_body_259.setValue("no");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_259);
			    		
			    		
			    		Attr attr2_body_260 = doc1.createAttribute("NOTUSED");

			    		attr2_body_260.setValue("no");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_260);
			    		
			    		
			    		Attr attr2_body_261 = doc1.createAttribute("MINDATALEN");

			    		attr2_body_261.setValue("0");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_261);
			    		
			    		
			    		Attr attr2_body_262 = doc1.createAttribute("MAXDATALEN");

			    		attr2_body_262.setValue("20");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_262);
			    		
			    		
			    		Attr attr2_body_263 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

			    		attr2_body_263.setValue("1");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_263);
			    		
			    		
			    		Attr attr2_body_264 = doc1.createAttribute("TYPE");

			    		attr2_body_264.setValue("string");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_264);
			    		
			    		
			    		Attr attr2_body_265 = doc1.createAttribute("FORMAT");

			    		attr2_body_265.setValue("");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_265);
			    		
			    		
			    		Attr attr2_body_266 = doc1.createAttribute("XMLTAG");

			    		attr2_body_266.setValue("WIDTH");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_266);
			    		
			    		
			    		Attr attr2_body_267 = doc1.createAttribute("USEPARENTNS");

			    		attr2_body_267.setValue("no");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_267);
			    		
			    		
			    		Attr attr2_body_268 = doc1.createAttribute("NAMESPACE");

			    		attr2_body_268.setValue("");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_268);
			    		
			    		
			    		Attr attr2_body_269 = doc1.createAttribute("ATTRTYPE");

			    		attr2_body_269.setValue("CDATA");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_269);
			    		
			    		
			    		Attr attr2_body_270 = doc1.createAttribute("ATTRBEHAVIOR");

			    		attr2_body_270.setValue("IMPLIED");

			    		xml_body_attr32_body_1.setAttributeNode(attr2_body_270);
			    		
			    		xml_rec5_body = doc1.createElement("XMLRECORD");
			    		
			    		xmlelement4body1.appendChild(xml_rec5_body);
			    		
			    		// set attr1_body_r2ibute to XMLRECORD element		
			    		
			    		attr1_body_r1 = doc1.createAttribute("NAME");

			    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

			    		xml_rec5_body.setAttributeNode(attr1_body_r1);
			    		
			    		
			    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

			    		attr1_body_r2.setValue("");

			    		xml_rec5_body.setAttributeNode(attr1_body_r2);

			    		
			    		attr1_body_r3 = doc1.createAttribute("NOTE");

			    		attr1_body_r3.setValue("");

			    		xml_rec5_body.setAttributeNode(attr1_body_r3);
			    		
			    		
			    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

			    		attr1_body_r4.setValue("yes");

			    		xml_rec5_body.setAttributeNode(attr1_body_r4);
			    		
			    		
			    		
			    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

			    		attr1_body_r5.setValue("0");

			    		xml_rec5_body.setAttributeNode(attr1_body_r5);
			    		
			    		
			    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

			    		attr1_body_r6.setValue("1");

			    		xml_rec5_body.setAttributeNode(attr1_body_r6);
			    		
			    		
			    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

			    		attr1_body_r7.setValue("normal");

			    		xml_rec5_body.setAttributeNode(attr1_body_r7);
			    		
			    		
			    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

			    		attr1_body_r8.setValue("");

			    		xml_rec5_body.setAttributeNode(attr1_body_r8);
			    		
			    		
			    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

			    		attr1_body_r9.setValue("pcdata");

			    		xml_rec5_body.setAttributeNode(attr1_body_r9);
			    		
			    		
			    		attr1_body_r10 = doc1.createAttribute("FLOATING");

			    		attr1_body_r10.setValue("no");

			    		xml_rec5_body.setAttributeNode(attr1_body_r10);
			    		
			    		xmlpcd = doc1.createElement("XMLPCDATA");
						xml_rec5_body.appendChild(xmlpcd);
						
						// set attribute to XMLPCDATA element		
						
						attr90 = doc1.createAttribute("NAME");

						attr90.setValue("STYLE2");

						xmlpcd.setAttributeNode(attr90);
						
						
						attr91 = doc1.createAttribute("DESCRIPTION");

						attr91.setValue("");

						xmlpcd.setAttributeNode(attr91);

						
						attr92 = doc1.createAttribute("NOTE");

						attr92.setValue("");

						xmlpcd.setAttributeNode(attr92);
						
						
						attr93 = doc1.createAttribute("ACTIVE");

						attr93.setValue("yes");

						xmlpcd.setAttributeNode(attr93);
						
						
						
						attr94 = doc1.createAttribute("MANDATORY");

						attr94.setValue("no");

						xmlpcd.setAttributeNode(attr94);
						
						
						attr95 = doc1.createAttribute("NOTUSED");

						attr95.setValue("no");

						xmlpcd.setAttributeNode(attr95);
						
						
						attr96 = doc1.createAttribute("MINDATALEN");

						attr96.setValue("0");

						xmlpcd.setAttributeNode(attr96);
						
						
						attr97 = doc1.createAttribute("MAXDATALEN");

						attr97.setValue("2000");

						xmlpcd.setAttributeNode(attr97);
						
						
						attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

						attr98.setValue("1");

						xmlpcd.setAttributeNode(attr98);
						
						
						attr99 = doc1.createAttribute("TYPE");

						attr99.setValue("string");

						xmlpcd.setAttributeNode(attr99);
						
						
						attr100 = doc1.createAttribute("FORMAT");

						attr100.setValue("");

						xmlpcd.setAttributeNode(attr100);
			    		
			    		}
			    		
			    		
			    		if (dummy1.item(m).getNodeName().equals("TD") || dummy1.item(m).getNodeName().equals("TR")) {
			    			//System.out.println(dummy1.item(m).getNodeName());
			    			
			    			NodeList dummy5 = dummy1.item(m).getChildNodes();
			    			for (int z = 0; z < dummy5.getLength(); z++) {
			    				
			    				if (dummy5.item(z).getNodeName().equals("#text")) {
			    					continue;
			    				}
			    				
			    				Element xmlelement6body1 = doc1.createElement("XMLELEMENT");
					    		xmlelement4body1.appendChild(xmlelement6body1);
					    		
					    		
					    		
					    		
					    		
					    		// set attr_body_ibute to XMLELEMENT element
					    		
					    		attr_body_80 = doc1.createAttribute("ALLOWANY");

					    		attr_body_80.setValue("no");

					    		xmlelement6body1.setAttributeNode(attr_body_80);
					    		
					    		
					    		attr_body_81 = doc1.createAttribute("NAME");

					    		 attr_body_81.setValue(dummy5.item(z).getNodeName() + ":" + z);
					    		
					    		xmlelement6body1.setAttributeNode(attr_body_81);
					    		
					    		
					    		attr_body_82 = doc1.createAttribute("DESCRIPTION");

					    		attr_body_82.setValue("");

					    		xmlelement6body1.setAttributeNode(attr_body_82);

					    		
					    		attr_body_83 = doc1.createAttribute("NOTE");

					    		attr_body_83.setValue("");

					    		xmlelement6body1.setAttributeNode(attr_body_83);
					    		
					    		
					    		attr_body_84 = doc1.createAttribute("ACTIVE");

					    		attr_body_84.setValue("yes");

					    		xmlelement6body1.setAttributeNode(attr_body_84);
					    		
					    		
					    		
					    		attr_body_85 = doc1.createAttribute("MINLOOP");

					    		attr_body_85.setValue("0");

					    		xmlelement6body1.setAttributeNode(attr_body_85);
					    		
					    		
					    		attr_body_86 = doc1.createAttribute("MAXLOOP");

					    		attr_body_86.setValue("1");

					    		xmlelement6body1.setAttributeNode(attr_body_86);
					    		
					    		
					    		attr_body_87 = doc1.createAttribute("XMLTAG");

					    		attr_body_87.setValue(dummy5.item(z).getNodeName());

					    		xmlelement6body1.setAttributeNode(attr_body_87);
					    		
					    		
					    		attr_body_88 = doc1.createAttribute("USEPARENTNS");

					    		attr_body_88.setValue("yes");

					    		xmlelement6body1.setAttributeNode(attr_body_88);
					    		
					    		//xmlelement4body1.appendChild(xml_rec5_body);
					    		
					    				
			    			
			    			Element xml_rec5_body2 = doc1.createElement("XMLRECORD");
			        		
			        		xmlelement6body1.appendChild(xml_rec5_body2);
			        		
			        		// set attr1_body_r2ibute to XMLRECORD element		
			        		
			        		attr1_body_r1 = doc1.createAttribute("NAME");

			        		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r1);
			        		
			        		
			        		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

			        		attr1_body_r2.setValue("");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r2);

			        		
			        		attr1_body_r3 = doc1.createAttribute("NOTE");

			        		attr1_body_r3.setValue("");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r3);
			        		
			        		
			        		attr1_body_r4 = doc1.createAttribute("ACTIVE");

			        		attr1_body_r4.setValue("yes");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r4);
			        		
			        		
			        		
			        		attr1_body_r5 = doc1.createAttribute("MINLOOP");

			        		attr1_body_r5.setValue("0");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r5);
			        		
			        		
			        		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

			        		attr1_body_r6.setValue("1");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r6);
			        		
			        		
			        		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

			        		attr1_body_r7.setValue("normal");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r7);
			        		
			        		
			        		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

			        		attr1_body_r8.setValue("");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r8);
			        		
			        		
			        		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

			        		attr1_body_r9.setValue("attribute");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r9);
			        		
			        		
			        		attr1_body_r10 = doc1.createAttribute("FLOATING");

			        		attr1_body_r10.setValue("no");

			        		xml_rec5_body2.setAttributeNode(attr1_body_r10);
			        		
			        		Element xml_body_attr12_body_1 = doc1.createElement("XMLATTR");
				    		xml_rec5_body2.appendChild(xml_body_attr12_body_1);
				    		
				    		// set attr2_body_1ibute to XMLATTR element		
				    		
				    		Attr attr2_body_155 = doc1.createAttribute("NAME");

				    		attr2_body_155.setValue("CLASSGH:613");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_155);
				    		
				    		
				    		Attr attr2_body_156 = doc1.createAttribute("DESCRIPTION");

				    		attr2_body_156.setValue("");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_156);

				    		
				    		Attr attr2_body_157 = doc1.createAttribute("NOTE");

				    		attr2_body_157.setValue("");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_157);
				    		
				    		
				    		Attr attr2_body_158 = doc1.createAttribute("ACTIVE");

				    		attr2_body_158.setValue("yes");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_158);
				    		
				    		
				    		
				    		Attr attr2_body_159 = doc1.createAttribute("MANDATORY");

				    		attr2_body_159.setValue("no");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_159);
				    		
				    		
				    		Attr attr2_body_160 = doc1.createAttribute("NOTUSED");

				    		attr2_body_160.setValue("no");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_160);
				    		
				    		
				    		Attr attr2_body_161 = doc1.createAttribute("MINDATALEN");

				    		attr2_body_161.setValue("0");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_161);
				    		
				    		
				    		Attr attr2_body_162 = doc1.createAttribute("MAXDATALEN");

				    		attr2_body_162.setValue("20");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_162);
				    		
				    		
				    		Attr attr2_body_163 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

				    		attr2_body_163.setValue("1");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_163);
				    		
				    		
				    		Attr attr2_body_164 = doc1.createAttribute("TYPE");

				    		attr2_body_164.setValue("string");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_164);
				    		
				    		
				    		Attr attr2_body_165 = doc1.createAttribute("FORMAT");

				    		attr2_body_165.setValue("");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_165);
				    		
				    		
				    		Attr attr2_body_166 = doc1.createAttribute("XMLTAG");

				    		attr2_body_166.setValue("CLASS");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_166);
				    		
				    		
				    		Attr attr2_body_167 = doc1.createAttribute("USEPARENTNS");

				    		attr2_body_167.setValue("no");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_167);
				    		
				    		
				    		Attr attr2_body_168 = doc1.createAttribute("NAMESPACE");

				    		attr2_body_168.setValue("");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_168);
				    		
				    		
				    		Attr attr2_body_169 = doc1.createAttribute("ATTRTYPE");

				    		attr2_body_169.setValue("CDATA");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_169);
				    		
				    		
				    		Attr attr2_body_170 = doc1.createAttribute("ATTRBEHAVIOR");

				    		attr2_body_170.setValue("IMPLIED");

				    		xml_body_attr12_body_1.setAttributeNode(attr2_body_170);

				    		
				    		// XMLATTR elements
				    		
				    		Element xml_body_attr32_body_1 = doc1.createElement("XMLATTR");
				    		xml_rec5_body2.appendChild(xml_body_attr32_body_1);
				    		
				    		// set attr2_body_2ibute to XMLATTR element		
				    		
				    		Attr attr2_body_255 = doc1.createAttribute("NAME");

				    		attr2_body_255.setValue("WIDTH:470");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_255);
				    		
				    		
				    		Attr attr2_body_256 = doc1.createAttribute("DESCRIPTION");

				    		attr2_body_256.setValue("");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_256);

				    		
				    		Attr attr2_body_257 = doc1.createAttribute("NOTE");

				    		attr2_body_257.setValue("");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_257);
				    		
				    		
				    		Attr attr2_body_258 = doc1.createAttribute("ACTIVE");

				    		attr2_body_258.setValue("yes");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_258);
				    		
				    		
				    		
				    		Attr attr2_body_259 = doc1.createAttribute("MANDATORY");

				    		attr2_body_259.setValue("no");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_259);
				    		
				    		
				    		Attr attr2_body_260 = doc1.createAttribute("NOTUSED");

				    		attr2_body_260.setValue("no");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_260);
				    		
				    		
				    		Attr attr2_body_261 = doc1.createAttribute("MINDATALEN");

				    		attr2_body_261.setValue("0");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_261);
				    		
				    		
				    		Attr attr2_body_262 = doc1.createAttribute("MAXDATALEN");

				    		attr2_body_262.setValue("20");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_262);
				    		
				    		
				    		Attr attr2_body_263 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

				    		attr2_body_263.setValue("1");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_263);
				    		
				    		
				    		Attr attr2_body_264 = doc1.createAttribute("TYPE");

				    		attr2_body_264.setValue("string");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_264);
				    		
				    		
				    		Attr attr2_body_265 = doc1.createAttribute("FORMAT");

				    		attr2_body_265.setValue("");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_265);
				    		
				    		
				    		Attr attr2_body_266 = doc1.createAttribute("XMLTAG");

				    		attr2_body_266.setValue("WIDTH");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_266);
				    		
				    		
				    		Attr attr2_body_267 = doc1.createAttribute("USEPARENTNS");

				    		attr2_body_267.setValue("no");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_267);
				    		
				    		
				    		Attr attr2_body_268 = doc1.createAttribute("NAMESPACE");

				    		attr2_body_268.setValue("");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_268);
				    		
				    		
				    		Attr attr2_body_269 = doc1.createAttribute("ATTRTYPE");

				    		attr2_body_269.setValue("CDATA");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_269);
				    		
				    		
				    		Attr attr2_body_270 = doc1.createAttribute("ATTRBEHAVIOR");

				    		attr2_body_270.setValue("IMPLIED");

				    		xml_body_attr32_body_1.setAttributeNode(attr2_body_270);
				    		
				    		xml_rec5_body = doc1.createElement("XMLRECORD");
				    		
				    		xmlelement6body1.appendChild(xml_rec5_body);
				    		
				    		// set attr1_body_r2ibute to XMLRECORD element		
				    		
				    		attr1_body_r1 = doc1.createAttribute("NAME");

				    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

				    		xml_rec5_body.setAttributeNode(attr1_body_r1);
				    		
				    		
				    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

				    		attr1_body_r2.setValue("");

				    		xml_rec5_body.setAttributeNode(attr1_body_r2);

				    		
				    		attr1_body_r3 = doc1.createAttribute("NOTE");

				    		attr1_body_r3.setValue("");

				    		xml_rec5_body.setAttributeNode(attr1_body_r3);
				    		
				    		
				    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

				    		attr1_body_r4.setValue("yes");

				    		xml_rec5_body.setAttributeNode(attr1_body_r4);
				    		
				    		
				    		
				    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

				    		attr1_body_r5.setValue("0");

				    		xml_rec5_body.setAttributeNode(attr1_body_r5);
				    		
				    		
				    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

				    		attr1_body_r6.setValue("1");

				    		xml_rec5_body.setAttributeNode(attr1_body_r6);
				    		
				    		
				    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

				    		attr1_body_r7.setValue("normal");

				    		xml_rec5_body.setAttributeNode(attr1_body_r7);
				    		
				    		
				    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

				    		attr1_body_r8.setValue("");

				    		xml_rec5_body.setAttributeNode(attr1_body_r8);
				    		
				    		
				    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

				    		attr1_body_r9.setValue("pcdata");

				    		xml_rec5_body.setAttributeNode(attr1_body_r9);
				    		
				    		
				    		attr1_body_r10 = doc1.createAttribute("FLOATING");

				    		attr1_body_r10.setValue("no");

				    		xml_rec5_body.setAttributeNode(attr1_body_r10);
				    		
				    		xmlpcd = doc1.createElement("XMLPCDATA");
							xml_rec5_body.appendChild(xmlpcd);
							
							// set attribute to XMLPCDATA element		
							
							attr90 = doc1.createAttribute("NAME");

							attr90.setValue("STYLE2");

							xmlpcd.setAttributeNode(attr90);
							
							
							attr91 = doc1.createAttribute("DESCRIPTION");

							attr91.setValue("");

							xmlpcd.setAttributeNode(attr91);

							
							attr92 = doc1.createAttribute("NOTE");

							attr92.setValue("");

							xmlpcd.setAttributeNode(attr92);
							
							
							attr93 = doc1.createAttribute("ACTIVE");

							attr93.setValue("yes");

							xmlpcd.setAttributeNode(attr93);
							
							
							
							attr94 = doc1.createAttribute("MANDATORY");

							attr94.setValue("no");

							xmlpcd.setAttributeNode(attr94);
							
							
							attr95 = doc1.createAttribute("NOTUSED");

							attr95.setValue("no");

							xmlpcd.setAttributeNode(attr95);
							
							
							attr96 = doc1.createAttribute("MINDATALEN");

							attr96.setValue("0");

							xmlpcd.setAttributeNode(attr96);
							
							
							attr97 = doc1.createAttribute("MAXDATALEN");

							attr97.setValue("2000");

							xmlpcd.setAttributeNode(attr97);
							
							
							attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

							attr98.setValue("1");

							xmlpcd.setAttributeNode(attr98);
							
							
							attr99 = doc1.createAttribute("TYPE");

							attr99.setValue("string");

							xmlpcd.setAttributeNode(attr99);
							
							
							attr100 = doc1.createAttribute("FORMAT");

							attr100.setValue("");

							xmlpcd.setAttributeNode(attr100);
			    			
			    			
			    			
			    			
			    			NodeList dummy2 = dummy5.item(z).getChildNodes();
			    			for (int n = 0; n < dummy2.getLength(); n++) {
			    				
			    				if (dummy2.item(n).getNodeName().equals("#text")) {
			    					continue;
			    				}
			    				
			    				Element xmlelement7body1 = doc1.createElement("XMLELEMENT");
					    		xmlelement6body1.appendChild(xmlelement7body1);
					    		
					    		 		
					    		
					    		
					    		// set attr_body_ibute to XMLELEMENT element
					    		
					    		attr_body_80 = doc1.createAttribute("ALLOWANY");

					    		attr_body_80.setValue("no");

					    		xmlelement7body1.setAttributeNode(attr_body_80);
					    		
					    		
					    		attr_body_81 = doc1.createAttribute("NAME");

					    		 attr_body_81.setValue(dummy2.item(n).getNodeName() + ":" + n);
					    		
					    		xmlelement7body1.setAttributeNode(attr_body_81);
					    		
					    		
					    		attr_body_82 = doc1.createAttribute("DESCRIPTION");

					    		attr_body_82.setValue("");

					    		xmlelement7body1.setAttributeNode(attr_body_82);

					    		
					    		attr_body_83 = doc1.createAttribute("NOTE");

					    		attr_body_83.setValue("");

					    		xmlelement7body1.setAttributeNode(attr_body_83);
					    		
					    		
					    		attr_body_84 = doc1.createAttribute("ACTIVE");

					    		attr_body_84.setValue("yes");

					    		xmlelement7body1.setAttributeNode(attr_body_84);
					    		
					    		
					    		
					    		attr_body_85 = doc1.createAttribute("MINLOOP");

					    		attr_body_85.setValue("0");

					    		xmlelement7body1.setAttributeNode(attr_body_85);
					    		
					    		
					    		attr_body_86 = doc1.createAttribute("MAXLOOP");

					    		attr_body_86.setValue("1");

					    		xmlelement7body1.setAttributeNode(attr_body_86);
					    		
					    		
					    		attr_body_87 = doc1.createAttribute("XMLTAG");

					    		attr_body_87.setValue(dummy2.item(n).getNodeName());

					    		xmlelement7body1.setAttributeNode(attr_body_87);
					    		
					    		
					    		attr_body_88 = doc1.createAttribute("USEPARENTNS");

					    		attr_body_88.setValue("yes");

					    		xmlelement7body1.setAttributeNode(attr_body_88);
			    			
					    		xml_rec5_body = doc1.createElement("XMLRECORD");
					    		
					    		xmlelement7body1.appendChild(xml_rec5_body);
					    		
					    		// set attr1_body_r2ibute to XMLRECORD element		
					    		
					    		attr1_body_r1 = doc1.createAttribute("NAME");

					    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

					    		xml_rec5_body.setAttributeNode(attr1_body_r1);
					    		
					    		
					    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

					    		attr1_body_r2.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r2);

					    		
					    		attr1_body_r3 = doc1.createAttribute("NOTE");

					    		attr1_body_r3.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r3);
					    		
					    		
					    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

					    		attr1_body_r4.setValue("yes");

					    		xml_rec5_body.setAttributeNode(attr1_body_r4);
					    		
					    		
					    		
					    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

					    		attr1_body_r5.setValue("0");

					    		xml_rec5_body.setAttributeNode(attr1_body_r5);
					    		
					    		
					    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

					    		attr1_body_r6.setValue("1");

					    		xml_rec5_body.setAttributeNode(attr1_body_r6);
					    		
					    		
					    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

					    		attr1_body_r7.setValue("normal");

					    		xml_rec5_body.setAttributeNode(attr1_body_r7);
					    		
					    		
					    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

					    		attr1_body_r8.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r8);
					    		
					    		
					    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

					    		attr1_body_r9.setValue("attribute");

					    		xml_rec5_body.setAttributeNode(attr1_body_r9);
					    		
					    		
					    		attr1_body_r10 = doc1.createAttribute("FLOATING");

					    		attr1_body_r10.setValue("no");

					    		xml_rec5_body.setAttributeNode(attr1_body_r10);
					    		
					    		xml_body_attr12_body_1 = doc1.createElement("XMLATTR");
					    		xml_rec5_body.appendChild(xml_body_attr12_body_1);
					    		
					    		// set attr2_body_1ibute to XMLATTR element		
					    		
					    		attr2_body_155 = doc1.createAttribute("NAME");

					    		attr2_body_155.setValue("CLASSGH:613");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_155);
					    		
					    		
					    		attr2_body_156 = doc1.createAttribute("DESCRIPTION");

					    		attr2_body_156.setValue("");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_156);

					    		
					    		attr2_body_157 = doc1.createAttribute("NOTE");

					    		attr2_body_157.setValue("");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_157);
					    		
					    		
					    		attr2_body_158 = doc1.createAttribute("ACTIVE");

					    		attr2_body_158.setValue("yes");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_158);
					    		
					    		
					    		
					    		attr2_body_159 = doc1.createAttribute("MANDATORY");

					    		attr2_body_159.setValue("no");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_159);
					    		
					    		
					    		attr2_body_160 = doc1.createAttribute("NOTUSED");

					    		attr2_body_160.setValue("no");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_160);
					    		
					    		
					    		attr2_body_161 = doc1.createAttribute("MINDATALEN");

					    		attr2_body_161.setValue("0");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_161);
					    		
					    		
					    		attr2_body_162 = doc1.createAttribute("MAXDATALEN");

					    		attr2_body_162.setValue("20");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_162);
					    		
					    		
					    		attr2_body_163 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

					    		attr2_body_163.setValue("1");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_163);
					    		
					    		
					    		attr2_body_164 = doc1.createAttribute("TYPE");

					    		attr2_body_164.setValue("string");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_164);
					    		
					    		
					    		attr2_body_165 = doc1.createAttribute("FORMAT");

					    		attr2_body_165.setValue("");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_165);
					    		
					    		
					    		attr2_body_166 = doc1.createAttribute("XMLTAG");

					    		attr2_body_166.setValue("CLASS");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_166);
					    		
					    		
					    		attr2_body_167 = doc1.createAttribute("USEPARENTNS");

					    		attr2_body_167.setValue("no");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_167);
					    		
					    		
					    		attr2_body_168 = doc1.createAttribute("NAMESPACE");

					    		attr2_body_168.setValue("");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_168);
					    		
					    		
					    		attr2_body_169 = doc1.createAttribute("ATTRTYPE");

					    		attr2_body_169.setValue("CDATA");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_169);
					    		
					    		
					    		attr2_body_170 = doc1.createAttribute("ATTRBEHAVIOR");

					    		attr2_body_170.setValue("IMPLIED");

					    		xml_body_attr12_body_1.setAttributeNode(attr2_body_170);

					    		
					    		// XMLATTR elements
					    		
					    		xml_body_attr32_body_1 = doc1.createElement("XMLATTR");
					    		xml_rec5_body.appendChild(xml_body_attr32_body_1);
					    		
					    		// set attr2_body_2ibute to XMLATTR element		
					    		
					    		attr2_body_255 = doc1.createAttribute("NAME");

					    		attr2_body_255.setValue("WIDTH:470");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_255);
					    		
					    		
					    		attr2_body_256 = doc1.createAttribute("DESCRIPTION");

					    		attr2_body_256.setValue("");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_256);

					    		
					    		attr2_body_257 = doc1.createAttribute("NOTE");

					    		attr2_body_257.setValue("");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_257);
					    		
					    		
					    		attr2_body_258 = doc1.createAttribute("ACTIVE");

					    		attr2_body_258.setValue("yes");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_258);
					    		
					    		
					    		
					    		attr2_body_259 = doc1.createAttribute("MANDATORY");

					    		attr2_body_259.setValue("no");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_259);
					    		
					    		
					    		attr2_body_260 = doc1.createAttribute("NOTUSED");

					    		attr2_body_260.setValue("no");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_260);
					    		
					    		
					    		attr2_body_261 = doc1.createAttribute("MINDATALEN");

					    		attr2_body_261.setValue("0");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_261);
					    		
					    		
					    		attr2_body_262 = doc1.createAttribute("MAXDATALEN");

					    		attr2_body_262.setValue("20");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_262);
					    		
					    		
					    		attr2_body_263 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

					    		attr2_body_263.setValue("1");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_263);
					    		
					    		
					    		attr2_body_264 = doc1.createAttribute("TYPE");

					    		attr2_body_264.setValue("string");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_264);
					    		
					    		
					    		attr2_body_265 = doc1.createAttribute("FORMAT");

					    		attr2_body_265.setValue("");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_265);
					    		
					    		
					    		attr2_body_266 = doc1.createAttribute("XMLTAG");

					    		attr2_body_266.setValue("WIDTH");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_266);
					    		
					    		
					    		attr2_body_267 = doc1.createAttribute("USEPARENTNS");

					    		attr2_body_267.setValue("no");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_267);
					    		
					    		
					    		 attr2_body_268 = doc1.createAttribute("NAMESPACE");

					    		attr2_body_268.setValue("");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_268);
					    		
					    		
					    		attr2_body_269 = doc1.createAttribute("ATTRTYPE");

					    		attr2_body_269.setValue("CDATA");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_269);
					    		
					    		
					    		attr2_body_270 = doc1.createAttribute("ATTRBEHAVIOR");

					    		attr2_body_270.setValue("IMPLIED");

					    		xml_body_attr32_body_1.setAttributeNode(attr2_body_270);
					    		
					    		xml_rec5_body = doc1.createElement("XMLRECORD");
					    		
					    		xmlelement7body1.appendChild(xml_rec5_body);
					    		
					    		// set attr1_body_r2ibute to XMLRECORD element		
					    		
					    		attr1_body_r1 = doc1.createAttribute("NAME");

					    		attr1_body_r1.setValue("_attr_RELEASE_NUMBER_B:4");

					    		xml_rec5_body.setAttributeNode(attr1_body_r1);
					    		
					    		
					    		attr1_body_r2 = doc1.createAttribute("DESCRIPTION");

					    		attr1_body_r2.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r2);

					    		
					    		attr1_body_r3 = doc1.createAttribute("NOTE");

					    		attr1_body_r3.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r3);
					    		
					    		
					    		attr1_body_r4 = doc1.createAttribute("ACTIVE");

					    		attr1_body_r4.setValue("yes");

					    		xml_rec5_body.setAttributeNode(attr1_body_r4);
					    		
					    		
					    		
					    		attr1_body_r5 = doc1.createAttribute("MINLOOP");

					    		attr1_body_r5.setValue("0");

					    		xml_rec5_body.setAttributeNode(attr1_body_r5);
					    		
					    		
					    		attr1_body_r6 = doc1.createAttribute("MAXLOOP");

					    		attr1_body_r6.setValue("1");

					    		xml_rec5_body.setAttributeNode(attr1_body_r6);
					    		
					    		
					    		attr1_body_r7 = doc1.createAttribute("LOOPCONTROL");

					    		attr1_body_r7.setValue("normal");

					    		xml_rec5_body.setAttributeNode(attr1_body_r7);
					    		
					    		
					    		attr1_body_r8 = doc1.createAttribute("ORDERINGTAG");

					    		attr1_body_r8.setValue("");

					    		xml_rec5_body.setAttributeNode(attr1_body_r8);
					    		
					    		
					    		attr1_body_r9 = doc1.createAttribute("RECORDTYPE");

					    		attr1_body_r9.setValue("pcdata");

					    		xml_rec5_body.setAttributeNode(attr1_body_r9);
					    		
					    		
					    		attr1_body_r10 = doc1.createAttribute("FLOATING");

					    		attr1_body_r10.setValue("no");

					    		xml_rec5_body.setAttributeNode(attr1_body_r10);
					    		
					    		xmlpcd = doc1.createElement("XMLPCDATA");
								xml_rec5_body.appendChild(xmlpcd);
								
								// set attribute to XMLPCDATA element		
								
								attr90 = doc1.createAttribute("NAME");

								attr90.setValue("STYLE2");

								xmlpcd.setAttributeNode(attr90);
								
								
								attr91 = doc1.createAttribute("DESCRIPTION");

								attr91.setValue("");

								xmlpcd.setAttributeNode(attr91);

								
								attr92 = doc1.createAttribute("NOTE");

								attr92.setValue("");

								xmlpcd.setAttributeNode(attr92);
								
								
								attr93 = doc1.createAttribute("ACTIVE");

								attr93.setValue("yes");

								xmlpcd.setAttributeNode(attr93);
								
								
								
								attr94 = doc1.createAttribute("MANDATORY");

								attr94.setValue("no");

								xmlpcd.setAttributeNode(attr94);
								
								
								attr95 = doc1.createAttribute("NOTUSED");

								attr95.setValue("no");

								xmlpcd.setAttributeNode(attr95);
								
								
								attr96 = doc1.createAttribute("MINDATALEN");

								attr96.setValue("0");

								xmlpcd.setAttributeNode(attr96);
								
								
								attr97 = doc1.createAttribute("MAXDATALEN");

								attr97.setValue("2000");

								xmlpcd.setAttributeNode(attr97);
								
								
								attr98 = doc1.createAttribute("ALLOWSIGNEDDECIMAL");

								attr98.setValue("1");

								xmlpcd.setAttributeNode(attr98);
								
								
								attr99 = doc1.createAttribute("TYPE");

								attr99.setValue("string");

								xmlpcd.setAttributeNode(attr99);
								
								
								attr100 = doc1.createAttribute("FORMAT");

								attr100.setValue("");

								xmlpcd.setAttributeNode(attr100);
			    			
			    			}
			    			}
			    		}
			    		
			    		
			    		
					}
					
				}
			
			}
		}
		
		
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();

		DOMSource source = new DOMSource(doc1);

		StreamResult result = new StreamResult(new File(System.getProperty("user.home") + "/outputDDF.ddf"));



		// Output to console for testing

		// StreamResult result = new StreamResult(System.out);



		transformer.transform(source, result);



		System.out.println("File saved!");
    
    }
    catch (Exception e) {
    	System.out.println(e);
    }
		
		String filePath = System.getProperty("user.home") + "/outputDDF.ddf";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();     
		
		
		
	}

}
