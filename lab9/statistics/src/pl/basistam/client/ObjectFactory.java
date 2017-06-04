
package pl.basistam.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.basistam.soa package. 
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

    private final static QName _AnalyzeCharSequence_QNAME = new QName("http://basistam.pl/", "analyzeCharSequence");
    private final static QName _AnalyzeCharSequenceResponse_QNAME = new QName("http://basistam.pl/", "analyzeCharSequenceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.basistam.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnalyzeCharSequenceResponse }
     * 
     */
    public AnalyzeCharSequenceResponse createAnalyzeCharSequenceResponse() {
        return new AnalyzeCharSequenceResponse();
    }

    /**
     * Create an instance of {@link AnalyzeCharSequence }
     * 
     */
    public AnalyzeCharSequence createAnalyzeCharSequence() {
        return new AnalyzeCharSequence();
    }

    /**
     * Create an instance of {@link CharSequenceData }
     * 
     */
    public CharSequenceData createCharSequenceData() {
        return new CharSequenceData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnalyzeCharSequence }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://basistam.pl/", name = "analyzeCharSequence")
    public JAXBElement<AnalyzeCharSequence> createAnalyzeCharSequence(AnalyzeCharSequence value) {
        return new JAXBElement<AnalyzeCharSequence>(_AnalyzeCharSequence_QNAME, AnalyzeCharSequence.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnalyzeCharSequenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://basistam.pl/", name = "analyzeCharSequenceResponse")
    public JAXBElement<AnalyzeCharSequenceResponse> createAnalyzeCharSequenceResponse(AnalyzeCharSequenceResponse value) {
        return new JAXBElement<AnalyzeCharSequenceResponse>(_AnalyzeCharSequenceResponse_QNAME, AnalyzeCharSequenceResponse.class, null, value);
    }

}
