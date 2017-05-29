
package pl.basistam.soa.parkingSpaceSensor.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ParkingSensorsService", targetNamespace = "http://webService.main.soa.basistam.pl", wsdlLocation = "file:/home/marcin/Documents/soa/Project/MainSystem/src/main/java/pl/basistam/soa/main/webService/ParkingSensorsService.wsdl")
public class ParkingSensorsService_Service
    extends Service
{

    private final static URL PARKINGSENSORSSERVICE_WSDL_LOCATION;
    private final static WebServiceException PARKINGSENSORSSERVICE_EXCEPTION;
    private final static QName PARKINGSENSORSSERVICE_QNAME = new QName("http://webService.main.soa.basistam.pl", "ParkingSensorsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/marcin/Documents/soa/Project/MainSystem/src/main/java/pl/basistam/soa/main/webService/ParkingSensorsService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARKINGSENSORSSERVICE_WSDL_LOCATION = url;
        PARKINGSENSORSSERVICE_EXCEPTION = e;
    }

    public ParkingSensorsService_Service() {
        super(__getWsdlLocation(), PARKINGSENSORSSERVICE_QNAME);
    }

    public ParkingSensorsService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), PARKINGSENSORSSERVICE_QNAME, features);
    }

    public ParkingSensorsService_Service(URL wsdlLocation) {
        super(wsdlLocation, PARKINGSENSORSSERVICE_QNAME);
    }

    public ParkingSensorsService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PARKINGSENSORSSERVICE_QNAME, features);
    }

    public ParkingSensorsService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ParkingSensorsService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ParkingSensorsService
     */
    @WebEndpoint(name = "ParkingSensorsService")
    public ParkingSensorsService getParkingSensorsService() {
        return super.getPort(new QName("http://webService.main.soa.basistam.pl", "ParkingSensorsService"), ParkingSensorsService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ParkingSensorsService
     */
    @WebEndpoint(name = "ParkingSensorsService")
    public ParkingSensorsService getParkingSensorsService(WebServiceFeature... features) {
        return super.getPort(new QName("http://webService.main.soa.basistam.pl", "ParkingSensorsService"), ParkingSensorsService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PARKINGSENSORSSERVICE_EXCEPTION!= null) {
            throw PARKINGSENSORSSERVICE_EXCEPTION;
        }
        return PARKINGSENSORSSERVICE_WSDL_LOCATION;
    }

}
