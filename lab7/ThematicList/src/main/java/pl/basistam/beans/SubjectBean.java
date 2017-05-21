package pl.basistam.beans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class SubjectBean {

    @ManagedProperty("#{thematicListBean}")
    private ThematicListBean thematicListBean;

    private String subject;

    public void setThematicListBean(ThematicListBean thematicListBean) {
        this.thematicListBean = thematicListBean;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void add(ActionEvent event) {
        if (subject != null && !subject.trim().isEmpty()) {
            thematicListBean.addSubject(subject);
        }
    }
}

