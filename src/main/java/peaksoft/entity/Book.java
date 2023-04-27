package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Genre;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private LocalDate published_year;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne(cascade = {REFRESH, MERGE, PERSIST, DETACH})
    private Author author;
    @ManyToOne(cascade = {REFRESH, MERGE, PERSIST, DETACH})
    private Publisher publisher;

    public Book(String name, String country, LocalDate published_year, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.published_year = published_year;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", published_year=" + published_year +
                ", price=" + price +
                ", gender=" + genre +
                '}';
    }
}
