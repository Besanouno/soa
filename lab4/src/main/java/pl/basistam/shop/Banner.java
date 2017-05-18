package pl.basistam.shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Random;

@ManagedBean(name = "banner")
@RequestScoped
public class Banner {
    private int pageNumber = 0;

    public String reloadBanner() {
        pageNumber = new Random().nextInt(2);
        return getPageNumber();
    }

    public String getPageNumber() {
        return Integer.toString(pageNumber);
    }
}
