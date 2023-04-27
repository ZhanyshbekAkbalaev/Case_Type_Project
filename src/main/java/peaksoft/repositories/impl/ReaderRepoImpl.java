package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Book;
import peaksoft.entity.Reader;
import peaksoft.repositories.ReaderRepository;

import java.util.List;

public class ReaderRepoImpl implements ReaderRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Reader saveReader(Long bookId,Reader reader) {
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b where b.id = :id", Book.class).setParameter("id", bookId).getSingleResult();
        reader.setBook(book);
        entityManager.merge(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        entityManager.getTransaction().begin();
        Reader re = entityManager.find(Reader.class, id);
        re.setName(reader.getName());
        re.setAge(reader.getAge());
        re.setEmail(reader.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
        return re.getName() + " Successfully updated reader!";
    }

    @Override
    public Reader getReaderByBookId(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.createQuery("select r from Reader r where r.book.id = :id", Reader.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public String deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, id);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted Reader.";
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        List<Reader> readers = entityManager.
                createQuery("select r from Reader r join Book b on r.book.id = b.id where b.author.id = :id", Reader.class).setParameter("id", id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return readers;
    }
}
