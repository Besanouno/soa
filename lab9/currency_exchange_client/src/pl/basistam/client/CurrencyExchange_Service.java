
package pl.basistam.client;

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
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CurrencyExchange", targetNamespace = "http://lab9.basistam.pl", wsdlLocation = "file:/home/marcin/Documents/soa/lab9/currency_exchange/src/pl/basistam/lab9/CurrencyExchange.wsdl")
public class CurrencyExchange_Service
    extends Service
{

    private final static URL CURRENCYEXCHANGE_WSDL_LOCATION;
    private final static WebServiceException CURRENCYEXCHANGE_EXCEPTION;
    private final static QName CURRENCYEXCHANGE_QNAME = new QName("http://lab9.basistam.pl", "CurrencyExchange");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/marcin/Documents/soa/lab9/currency_exchange/src/pl/basistam/lab9/CurrencyExchange.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURRENCYEXCHANGE_WSDL_LOCATION = url;
        CURRENCYEXCHANGE_EXCEPTION = e;
    }

    public CurrencyExchange_Service() {
        super(__getWsdlLocation(), CURRENCYEXCHANGE_QNAME);
    }

    public CurrencyExchange_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURRENCYEXCHANGE_QNAME, features);
    }

    public CurrencyExchange_Service(URL wsdlLocation) {
        super(wsdlLocation, CURRENCYEXCHANGE_QNAME);
    }

    public CurrencyExchange_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURRENCYEXCHANGE_QNAME, features);
    }

    public CurrencyExchange_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CurrencyExchange_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CurrencyExchange
     */
    @WebEndpoint(name = "CurrencyExchange")
    public CurrencyExchange getCurrencyExchange() {
        return super.getPort(new QName("http://lab9.basistam.pl", "CurrencyExchange"), CurrencyExchange.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CurrencyExchange
     */
    @WebEndpoint(name = "CurrencyExchange")
    public CurrencyExchange getCurrencyExchange(WebServiceFeature... features) {
        return super.getPort(new QName("http://lab9.basistam.pl", "CurrencyExchange"), CurrencyExchange.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURRENCYEXCHANGE_EXCEPTION!= null) {
            throw CURRENCYEXCHANGE_EXCEPTION;
        }
        return CURRENCYEXCHANGE_WSDL_LOCATION;
    }

}
