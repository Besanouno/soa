package pl.basistam.receiver;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Set<String> subjects = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public boolean shouldReceive(String subject) {
        return subjects.contains(subject);
    }

    public String getName() {
        return name;
    }
}
