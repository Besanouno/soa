package pl.basistam.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "area_employee")
public class AreaEmployee implements Serializable {
    @OneToOne
    @Id
    private User employee;
    private Integer area;
}
