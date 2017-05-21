package pl.basistam;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ManagedBean(name = "register")
@ApplicationScoped
public class CompanyRegister implements Serializable {
    private Set<String> data = new HashSet<>();

    public void add(String company) {
        System.out.println(company);
        data.add(company);
    }

    public Set<String> getAll() {
        return data;
    }
}
