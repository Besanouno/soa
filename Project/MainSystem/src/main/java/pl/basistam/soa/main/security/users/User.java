package pl.basistam.soa.main.security.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
}