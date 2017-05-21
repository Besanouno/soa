package pl.basistam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean(name = "companyBean")
@SessionScoped
public class CompanyBean {
    @Inject
    private MessageSender sender;

    private String name;
    private String nip;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String send() {
        sender.send(this.toString());
        return "result.xhtml";
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
