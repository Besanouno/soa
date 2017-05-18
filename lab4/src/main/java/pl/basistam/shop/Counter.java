package pl.basistam.shop;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "counter")
@ApplicationScoped
public class Counter {
    private int counter = 0;

    public void click(String pageNumber) throws IOException {
        counter++;
        System.out.println(counter);
        String page = "";
        if ("0".equals(pageNumber)) {
            page = "http://www.bmw.com";
        } else if ("1".equals(pageNumber)){
            page = "http://www.mercedes.com";
        };
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(page);
    }
}
