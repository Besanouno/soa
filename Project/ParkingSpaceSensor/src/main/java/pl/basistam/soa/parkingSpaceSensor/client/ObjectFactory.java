
package pl.basistam.soa.parkingSpaceSensor.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.basistam.soa.parkingSpaceSensor.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TakeParkingSpot_QNAME = new QName("http://webService.main.soa.basistam.pl/", "takeParkingSpot");
    private final static QName _TakeParkingSpotResponse_QNAME = new QName("http://webService.main.soa.basistam.pl/", "takeParkingSpotResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.basistam.soa.parkingSpaceSensor.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TakeParkingSpotResponse }
     * 
     */
    public TakeParkingSpotResponse createTakeParkingSpotResponse() {
        return new TakeParkingSpotResponse();
    }

    /**
     * Create an instance of {@link TakeParkingSpot }
     * 
     */
    public TakeParkingSpot createTakeParkingSpot() {
        return new TakeParkingSpot();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TakeParkingSpot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.main.soa.basistam.pl/", name = "takeParkingSpot")
    public JAXBElement<TakeParkingSpot> createTakeParkingSpot(TakeParkingSpot value) {
        return new JAXBElement<TakeParkingSpot>(_TakeParkingSpot_QNAME, TakeParkingSpot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TakeParkingSpotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.main.soa.basistam.pl/", name = "takeParkingSpotResponse")
    public JAXBElement<TakeParkingSpotResponse> createTakeParkingSpotResponse(TakeParkingSpotResponse value) {
        return new JAXBElement<TakeParkingSpotResponse>(_TakeParkingSpotResponse_QNAME, TakeParkingSpotResponse.class, null, value);
    }

}
