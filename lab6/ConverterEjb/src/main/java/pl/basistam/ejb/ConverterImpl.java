package pl.basistam.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Converter.class)
public class ConverterImpl implements Converter {
    public double fahr2cels(double temp) {
        return 5 / 9 * (temp - 32);
    }

    public double cels2fahr(double temp) {
        return 9 / 5 * temp + 32;
    }
}
