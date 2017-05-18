package pl.basistam.login;

public class User {
    private String nick;
    private String password;

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public boolean verify(User user) {
        return nick.equals(user.nick)
                && password.equals(user.password);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof User) {
            User user = (User) object;
            return nick.equals(user.nick);
        }
        return false;
     }
}
