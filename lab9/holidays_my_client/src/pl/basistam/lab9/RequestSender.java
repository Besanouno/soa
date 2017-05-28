package pl.basistam.lab9;

import javax.xml.soap.*;

public class RequestSender {

    public void send(SoapService service) {
        SOAPConnectionFactory soapConnectionFactory = null;
        SOAPConnection soapConnection = null;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapResponse = soapConnection.call(service.createRequest(), service.getUrl());
            service.parseResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
