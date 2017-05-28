
package pl.basistam.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.basistam.client package. 
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

    private final static QName _GetActualCourse_QNAME = new QName("http://lab9.basistam.pl/", "getActualCourse");
    private final static QName _ConvertToPlnResponse_QNAME = new QName("http://lab9.basistam.pl/", "convertToPlnResponse");
    private final static QName _GetActualCourseResponse_QNAME = new QName("http://lab9.basistam.pl/", "getActualCourseResponse");
    private final static QName _ConvertToPln_QNAME = new QName("http://lab9.basistam.pl/", "convertToPln");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.basistam.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertToPlnResponse }
     * 
     */
    public ConvertToPlnResponse createConvertToPlnResponse() {
        return new ConvertToPlnResponse();
    }

    /**
     * Create an instance of {@link GetActualCourse }
     * 
     */
    public GetActualCourse createGetActualCourse() {
        return new GetActualCourse();
    }

    /**
     * Create an instance of {@link GetActualCourseResponse }
     * 
     */
    public GetActualCourseResponse createGetActualCourseResponse() {
        return new GetActualCourseResponse();
    }

    /**
     * Create an instance of {@link ConvertToPln }
     * 
     */
    public ConvertToPln createConvertToPln() {
        return new ConvertToPln();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActualCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab9.basistam.pl/", name = "getActualCourse")
    public JAXBElement<GetActualCourse> createGetActualCourse(GetActualCourse value) {
        return new JAXBElement<GetActualCourse>(_GetActualCourse_QNAME, GetActualCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertToPlnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab9.basistam.pl/", name = "convertToPlnResponse")
    public JAXBElement<ConvertToPlnResponse> createConvertToPlnResponse(ConvertToPlnResponse value) {
        return new JAXBElement<ConvertToPlnResponse>(_ConvertToPlnResponse_QNAME, ConvertToPlnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActualCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab9.basistam.pl/", name = "getActualCourseResponse")
    public JAXBElement<GetActualCourseResponse> createGetActualCourseResponse(GetActualCourseResponse value) {
        return new JAXBElement<GetActualCourseResponse>(_GetActualCourseResponse_QNAME, GetActualCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertToPln }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab9.basistam.pl/", name = "convertToPln")
    public JAXBElement<ConvertToPln> createConvertToPln(ConvertToPln value) {
        return new JAXBElement<ConvertToPln>(_ConvertToPln_QNAME, ConvertToPln.class, null, value);
    }

}
