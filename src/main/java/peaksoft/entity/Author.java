package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_gen")
    @SequenceGenerator(name = "author_gen", sequenceName = "author_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate date_of_birth;
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = FetchType.EAGER)
    private List<Publisher> publishers;
    @OneToMany(cascade = {ALL,
            PERSIST,
            MERGE,
            REMOVE,
            REFRESH,
            DETACH}, mappedBy = "author")
    private List<Book> books;

    public Author(String firstName, String lastName, String email, LocalDate date_of_birth, String country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.country = country;
        this.gender = gender;
    }

    public void addPublisher(Publisher publisher) {
        publishers.add(publisher);
    }

    @Override
    public String toString() {
        return "\nAuthor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                '\n';
    }
}
