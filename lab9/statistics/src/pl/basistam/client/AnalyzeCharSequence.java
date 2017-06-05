
package pl.basistam.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for analyzeCharSequence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="analyzeCharSequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="charSequence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analyzeCharSequence", propOrder = {
    "charSequence"
})
public class AnalyzeCharSequence {

    protected String charSequence;

    /**
     * Gets the value of the charSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharSequence() {
        return charSequence;
    }

    /**
     * Sets the value of the charSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharSequence(String value) {
        this.charSequence = value;
    }

}
