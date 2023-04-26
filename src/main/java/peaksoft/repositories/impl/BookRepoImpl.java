package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Book;
import peaksoft.repositories.BookRepository;

public class BookRepoImpl implements BookRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Book saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public String updateBookAuthor(Long id, Book book) {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Book getBookAndPublisherByBookId(Long id) {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public String deleteBookByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }
}
