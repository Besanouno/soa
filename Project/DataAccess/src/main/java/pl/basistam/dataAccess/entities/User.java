package pl.basistam.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.basistam.dataAccess.common.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
}