package pl.basistam.shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

@SessionScoped
@ManagedBean(name="oldClientQuestionnaire")
public class OldClientQuestionnaire {
    private String lastShopping;
    private String satisfactionWithShopping;
    private String satisfactionWithService;
    private String comments;

    public String getLastShopping() {
        return lastShopping;
    }

    public void setLastShopping(String lastShopping) {
        this.lastShopping = lastShopping;
    }

    public String getSatisfactionWithShopping() {
        return satisfactionWithShopping;
    }

    public void setSatisfactionWithShopping(String satisfactionWithShopping) {
        this.satisfactionWithShopping = satisfactionWithShopping;
    }

    public String getSatisfactionWithService() {
        return satisfactionWithService;
    }

    public void setSatisfactionWithService(String satisfactionWithService) {
        this.satisfactionWithService = satisfactionWithService;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
