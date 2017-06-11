package pl.basistam.soa.main.jsf;

import lombok.Getter;
import lombok.Setter;
import pl.basistam.dataAccess.api.UsersDao;
import pl.basistam.soa.main.EjbBindings;

import javax.ejb.EJB;
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

    @EJB(mappedName = EjbBindings.UsersDao_JNDI)
    private UsersDao usersDAO;

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
