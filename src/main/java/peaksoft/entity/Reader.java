package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader_gen")
    @SequenceGenerator(name = "reader_gen", sequenceName = "reader_seq", allocationSize = 1)
    private Long id;
    private String name;
    private int age;
    private String email;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.REMOVE})
    private Book book;

    public Reader(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
