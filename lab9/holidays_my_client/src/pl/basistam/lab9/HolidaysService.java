package pl.basistam.lab9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class HolidaysService implements SoapService {

    private final String URL = "http://localhost:8080//services/Holidays";
    private final String NAMESPACE = "ns2";
    private final String SERVER_URI = "http://service.basistam.pl/";

    @Override
    public SOAPMessage createRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAMESPACE, SERVER_URI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        soapBody.addChildElement("getDaysLastToHolidays", NAMESPACE);

        soapMessage.saveChanges();
        return soapMessage;
    }

    @Override
    public void parseResponse(SOAPMessage soapResponse) throws Exception {
        String response = mapResponseToString(soapResponse);
        Document document = mapStringToXml(response);
        System.out.println(getString("return", document.getDocumentElement()));
    }

    private String mapResponseToString(SOAPMessage response) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = response.getSOAPPart().getContent();
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(sourceContent,result);
        return writer.toString();
    }

    private Document mapStringToXml(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    private String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }

    @Override
    public String getUrl() {
        return this.URL;
    }


}
