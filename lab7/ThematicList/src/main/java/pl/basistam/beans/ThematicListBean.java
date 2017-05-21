package pl.basistam.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Set;
import java.util.TreeSet;

@ManagedBean
@ApplicationScoped
public class ThematicListBean {
    private Set<String> subjects = new TreeSet<>();

    public Set<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }
}
