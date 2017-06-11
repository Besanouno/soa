package pl.basistam.soa.main.jsf;

import lombok.Getter;
import lombok.Setter;
import pl.basistam.dataAccess.api.UsersDao;
import pl.basistam.soa.main.EjbBindings;
import pl.basistam.soa.main.security.CurrentSession;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class UserPanel {
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

    @EJB(mappedName = EjbBindings.UsersDao_JNDI)
    private UsersDao usersDAO;

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

    public int getArea() {
        return usersDAO.getAreaForUser(currentSession.getCurrentUserId());
    }
}
