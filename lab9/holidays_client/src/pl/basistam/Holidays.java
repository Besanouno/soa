
package pl.basistam;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Holidays", targetNamespace = "http://service.basistam.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Holidays {


    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDaysLastToHolidays", targetNamespace = "http://service.basistam.pl/", className = "pl.basistam.GetDaysLastToHolidays")
    @ResponseWrapper(localName = "getDaysLastToHolidaysResponse", targetNamespace = "http://service.basistam.pl/", className = "pl.basistam.GetDaysLastToHolidaysResponse")
    @Action(input = "http://service.basistam.pl/Holidays/getDaysLastToHolidaysRequest", output = "http://service.basistam.pl/Holidays/getDaysLastToHolidaysResponse")
    public int getDaysLastToHolidays();

}