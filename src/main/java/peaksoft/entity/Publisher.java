package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_gen")
    @SequenceGenerator(name = "publisher_gen", sequenceName = "publisher_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @ManyToMany(cascade = {MERGE,PERSIST,REFRESH,DETACH},mappedBy = "publishers")
    private List<Author> authors;
    @OneToMany(cascade = {REFRESH,PERSIST,MERGE,DETACH},mappedBy = "publisher")
    private List<Book> books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
