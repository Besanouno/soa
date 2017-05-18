package pl.basistam.zad1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "random")
public class RandomBean {
    private static int randomNumber = (int) (Math.random() * 5 + 1);

    public String redirect(String pageId) {
        if (Integer.toString(randomNumber).equals(pageId)) {
            return "trafiony";
        }
        return pageId;
    }
}
