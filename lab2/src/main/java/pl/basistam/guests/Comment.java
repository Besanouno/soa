package pl.basistam.guests;

/**
 * Created by marcin on 23.03.17.
 */
public class Comment {
    private String user;
    private String content;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(String user, String content) {
        this.user = user;
        this.content = content;
    }
}
