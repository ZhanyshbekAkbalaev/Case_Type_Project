package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Author;
import peaksoft.entity.Book;
import peaksoft.entity.Publisher;
import peaksoft.repositories.BookRepository;

import java.util.List;
import java.util.Objects;

public class BookRepoImpl implements BookRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public Book saveBook(Long authorId, Long publisherId, Book book) {
        entityManager.getTransaction().begin();
        Author author = entityManager.createQuery("select a from Author a where a.id = :id", Author.class).setParameter("id", authorId).getSingleResult();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id = :id", Publisher.class).setParameter("id", publisherId).getSingleResult();
        book.setPublisher(publisher);
        book.setAuthor(author);
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public String updateBookAuthor(Long id, Book book) {
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class, id);
        book1.setName(book.getName());
        book1.setCountry(book.getCountry());
        book1.setPublished_year(book.getPublished_year());
        book1.setPrice(book.getPrice());
        book1.setGenre(book.getGenre());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated book!";
    }

    @Override
    public Book getBookAndPublisherByBookId(Long id) {
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b join Publisher p on p.id = b.publisher.id where b.id = :id", Book.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public String deleteBookByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b where b.author.id = :id", Book.class).setParameter("id", id).getSingleResult();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book.getName() + "Successfully book by author id!!!";
    }
}
