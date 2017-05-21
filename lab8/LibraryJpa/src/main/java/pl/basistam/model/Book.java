package pl.basistam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    private String author;

    private String title;

    private int year;

    private BigDecimal price;
}
