
package pl.basistam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.basistam package. 
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

    private final static QName _GetDaysLastToHolidays_QNAME = new QName("http://service.basistam.pl/", "getDaysLastToHolidays");
    private final static QName _GetDaysLastToHolidaysResponse_QNAME = new QName("http://service.basistam.pl/", "getDaysLastToHolidaysResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.basistam
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDaysLastToHolidaysResponse }
     * 
     */
    public GetDaysLastToHolidaysResponse createGetDaysLastToHolidaysResponse() {
        return new GetDaysLastToHolidaysResponse();
    }

    /**
     * Create an instance of {@link GetDaysLastToHolidays }
     * 
     */
    public GetDaysLastToHolidays createGetDaysLastToHolidays() {
        return new GetDaysLastToHolidays();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysLastToHolidays }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.basistam.pl/", name = "getDaysLastToHolidays")
    public JAXBElement<GetDaysLastToHolidays> createGetDaysLastToHolidays(GetDaysLastToHolidays value) {
        return new JAXBElement<GetDaysLastToHolidays>(_GetDaysLastToHolidays_QNAME, GetDaysLastToHolidays.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysLastToHolidaysResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.basistam.pl/", name = "getDaysLastToHolidaysResponse")
    public JAXBElement<GetDaysLastToHolidaysResponse> createGetDaysLastToHolidaysResponse(GetDaysLastToHolidaysResponse value) {
        return new JAXBElement<GetDaysLastToHolidaysResponse>(_GetDaysLastToHolidaysResponse_QNAME, GetDaysLastToHolidaysResponse.class, null, value);
    }

}
