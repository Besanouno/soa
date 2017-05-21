package pl.basistma.receiver;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
@Data
public class Logger {
    private String name;
    private boolean subscribe;

    @Inject
    private Users users;

    public String logIn() {
        users.add(new User(name, subscribe));
        return "loginResult.xhtml";
    }
}
