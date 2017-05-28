package pl.basistam.lab9;

import javax.xml.soap.SOAPMessage;

public interface SoapService {
    SOAPMessage createRequest() throws Exception;
    void parseResponse(SOAPMessage response) throws Exception;
    String getUrl();
}
