package pl.basistam.soa.main.jsf;

import lombok.Getter;
import lombok.Setter;
import pl.basistam.soa.main.security.users.UsersDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class AdminPanel {
    @Getter
    @Setter
    private String user;
    @Getter
    @Setter
    private String newPassword;
    @Getter
    @Setter
    private String passwordRepeated;

    @Inject
    private UsersDAO usersDAO;

    public String changePassword() {
        if (usersDAO.changePassword(user, newPassword)) {
            user = "";
            newPassword = "";
            passwordRepeated = "";
        }
        return "passwordPanel.xhtml";
    }

    public boolean passwordsMatches() {
        return newPassword != null && !newPassword.isEmpty() && newPassword.equals(passwordRepeated);
    }
}
