package pl.basistam.soa.main.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.basistam.soa.main.users.Role;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String password;
    private String name;
    private int area;
    @Enumerated(EnumType.STRING)
    private Role role;
}