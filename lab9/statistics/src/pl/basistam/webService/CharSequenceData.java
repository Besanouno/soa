package pl.basistam.webService;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "charSequenceData", propOrder = {
        "numberOfChars",
        "numberOfWhiteSpaces",
        "numberOfUppercase",
        "numberOfLowercase",
        "numberOfDigits"
})
public class CharSequenceData {

    private int numberOfChars;
    private int numberOfWhiteSpaces;
    private int numberOfUppercase;
    private int numberOfLowercase;
    private int numberOfDigits;

    public CharSequenceData() {
    }

    public int getNumberOfChars() {
        return numberOfChars;
    }

    public int getNumberOfWhiteSpaces() {
        return numberOfWhiteSpaces;
    }

    public int getNumberOfUppercase() {
        return numberOfUppercase;
    }

    public int getNumberOfLowercase() {
        return numberOfLowercase;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public CharSequenceData(int numberOfChars, int numberOfWhiteSpaces, int numberOfUppercase, int numberOfLowercase, int numberOfDigits) {
        this.numberOfChars = numberOfChars;
        this.numberOfWhiteSpaces = numberOfWhiteSpaces;
        this.numberOfUppercase = numberOfUppercase;
        this.numberOfLowercase = numberOfLowercase;
        this.numberOfDigits = numberOfDigits;
    }
}
