package pl.basistam.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class StatisticsService {

    @WebMethod
    public CharSequenceData analyzeCharSequence(String charSequence) {
        int numberOfChars = charSequence.length();
        int numberOfWhiteSpaces = 0;
        int numberOfUppercase = 0;
        int numberOfLowercase = 0;
        int numberOfDigits = 0;

        for (int i = 0; i < charSequence.length(); i++) {
            char c = charSequence.charAt(i);
            if (Character.isWhitespace(c)) {
                numberOfWhiteSpaces++;
            } else if (Character.isUpperCase(c)) {
                numberOfUppercase++;
            } else if (Character.isLowerCase(c)) {
                numberOfLowercase++;
            } else if (Character.isDigit(c)) {
                numberOfDigits++;
            }
        }

        return new CharSequenceData(
                numberOfChars,
                numberOfWhiteSpaces,
                numberOfUppercase,
                numberOfLowercase,
                numberOfDigits);
    }
}
