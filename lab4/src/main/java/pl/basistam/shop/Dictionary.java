package pl.basistam.shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "dictionary")
public class Dictionary {
    public static final String MAN = "mezczyzna";
    public static final String WOMAN = "kobieta";

    public String make(String gender) {
        return MAN.equals(gender) ? "robiłeś" : "robiłaś";
    }

    public String happy(String gender) {
        return MAN.equals(gender) ? "zadowolony" : "zadowolona";
    }
}
