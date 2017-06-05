
package pl.basistam.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for analyzeCharSequenceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="analyzeCharSequenceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://basistam.pl/}charSequenceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analyzeCharSequenceResponse", propOrder = {
    "data"
})
public class AnalyzeCharSequenceResponse {

    protected CharSequenceData data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link CharSequenceData }
     *     
     */
    public CharSequenceData getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharSequenceData }
     *     
     */
    public void setData(CharSequenceData value) {
        this.data = value;
    }

}
