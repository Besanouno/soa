
package pl.basistam.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for charSequenceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="charSequenceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfChars" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfWhiteSpaces" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfUppercase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfLowercase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfDigits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "charSequenceData", propOrder = {
    "numberOfChars",
    "numberOfWhiteSpaces",
    "numberOfUppercase",
    "numberOfLowercase",
    "numberOfDigits"
})
public class CharSequenceData {

    protected int numberOfChars;
    protected int numberOfWhiteSpaces;
    protected int numberOfUppercase;
    protected int numberOfLowercase;
    protected int numberOfDigits;

    /**
     * Gets the value of the numberOfChars property.
     * 
     */
    public int getNumberOfChars() {
        return numberOfChars;
    }

    /**
     * Sets the value of the numberOfChars property.
     * 
     */
    public void setNumberOfChars(int value) {
        this.numberOfChars = value;
    }

    /**
     * Gets the value of the numberOfWhiteSpaces property.
     * 
     */
    public int getNumberOfWhiteSpaces() {
        return numberOfWhiteSpaces;
    }

    /**
     * Sets the value of the numberOfWhiteSpaces property.
     * 
     */
    public void setNumberOfWhiteSpaces(int value) {
        this.numberOfWhiteSpaces = value;
    }

    /**
     * Gets the value of the numberOfUppercase property.
     * 
     */
    public int getNumberOfUppercase() {
        return numberOfUppercase;
    }

    /**
     * Sets the value of the numberOfUppercase property.
     * 
     */
    public void setNumberOfUppercase(int value) {
        this.numberOfUppercase = value;
    }

    /**
     * Gets the value of the numberOfLowercase property.
     * 
     */
    public int getNumberOfLowercase() {
        return numberOfLowercase;
    }

    /**
     * Sets the value of the numberOfLowercase property.
     * 
     */
    public void setNumberOfLowercase(int value) {
        this.numberOfLowercase = value;
    }

    /**
     * Gets the value of the numberOfDigits property.
     * 
     */
    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    /**
     * Sets the value of the numberOfDigits property.
     * 
     */
    public void setNumberOfDigits(int value) {
        this.numberOfDigits = value;
    }

}
