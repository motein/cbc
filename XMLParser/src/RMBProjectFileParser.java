import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RMBProjectFileParser {
	
	private final static String RMB_PROJECT_FILE = "rmbproject";
	private final static String PROJECT_TAG = "rmb_project";
	private final static String PROPERTY_TAG = "rmb_property";
	private final static String TIMESTAMP_ATTR_VALUE = "timestamp";
	private final static String NAME_ATTR_ID = "name";
	
	public static void main(String[] args) {
		RMBProjectFileParser parser = new RMBProjectFileParser();
		parser.update(RMB_PROJECT_FILE);
		String ret = parser.getTimeStamp(RMB_PROJECT_FILE);
		System.err.println(ret);
	}
	
	public String getTimeStamp(String xml_path) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(xml_path);
            Element doc = dom.getDocumentElement();
            return getPropertyValue(doc, TIMESTAMP_ATTR_VALUE);
        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return null;
    }
	
	public void update(String xml_path) {
	    Document dom;
	    Element elem = null;
	    
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        dom = db.newDocument();

	        // create the root element
	        Element rootEle = dom.createElement(PROJECT_TAG);

	        // create data elements and place them under root
	        elem = dom.createElement(PROPERTY_TAG);
	        elem.setAttribute("name", "version");
	        elem.appendChild(dom.createTextNode("1.0"));
	        rootEle.appendChild(elem);
	        
	        elem = dom.createElement(PROPERTY_TAG);
	        elem.setAttribute("name", "timestamp");
	        elem.appendChild(dom.createTextNode(String.valueOf(System.currentTimeMillis())));
	        rootEle.appendChild(elem);

	        dom.appendChild(rootEle);

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.STANDALONE, "no");
	            tr.setOutputProperty(OutputKeys.VERSION, "1.0");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	            
	            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(xml_path)));
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	
	private String getPropertyValue(Element doc, String name) {
	    String value = null;
	    NodeList nodeList = doc.getElementsByTagName(PROPERTY_TAG);
	    for (int i = 0; i < nodeList.getLength(); i++) {
	    	if (nodeList.item(i).getAttributes().getNamedItem(NAME_ATTR_ID).getNodeValue().equals(name)) {
		    	return nodeList.item(i).getFirstChild().getNodeValue();
	    	}
	    }
	    
	    return value;
	}
}
