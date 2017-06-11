package pl.basistam.soa.main.jsf;

import lombok.Getter;
import lombok.Setter;
import pl.basistam.soa.main.security.CurrentSession;
import pl.basistam.soa.main.security.users.UsersDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class PasswordPanel {
    @Inject
    private CurrentSession currentSession;

    @Getter
    @Setter
    private String oldPassword;
    @Getter
    @Setter
    private String newPassword;
    @Getter
    @Setter
    private String passwordRepeated;

    @Inject
    private UsersDAO usersDAO;

    public String changePassword() {
        if (usersDAO.changePassword(currentSession.getCurrentUserId(), oldPassword, newPassword)) {
            oldPassword = "";
            newPassword = "";
            passwordRepeated = "";
        }
        return "passwordPanel.xhtml";
    }

    public boolean passwordsMatches() {
        return newPassword != null && !newPassword.isEmpty() && newPassword.equals(passwordRepeated);
    }
}
