package pl.basistam.shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name="newClientQuestionnaire")
public class NewClientQuestionnaire {
    private String maxSpentMoney;
    private List<String> favouritePlaces;
    private String purchasesFrequency;
    private List<String> favouriteColours;
    private List<String> prefferedClothes;

    public String getMaxSpentMoney() {
        return maxSpentMoney;
    }

    public void setMaxSpentMoney(String maxSpentMoney) {
        this.maxSpentMoney = maxSpentMoney;
    }

    public List<String> getFavouritePlaces() {
        return favouritePlaces;
    }

    public void setFavouritePlaces(List<String> favouritePlaces) {
        this.favouritePlaces = favouritePlaces;
    }

    public String getPurchasesFrequency() {
        return purchasesFrequency;
    }

    public void setPurchasesFrequency(String purchasesFrequency) {
        this.purchasesFrequency = purchasesFrequency;
    }

    public List<String> getFavouriteColours() {
        return favouriteColours;
    }

    public void setFavouriteColours(List<String> favouriteColours) {
        this.favouriteColours = favouriteColours;
    }

    public List<String> getPrefferedClothes() {
        return prefferedClothes;
    }

    public void setPrefferedClothes(List<String> prefferedClothes) {
        this.prefferedClothes = prefferedClothes;
    }
}

