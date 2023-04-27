package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Author;
import peaksoft.entity.Publisher;
import peaksoft.repositories.AuthorRepository;

import java.util.List;
import java.util.Objects;

public class AuthorRepoImpl implements AuthorRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public Author saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author au = entityManager.createQuery("select a from Author a where a.id = :id", Author.class).setParameter("id", id).getSingleResult();
        au.setFirstName(author.getFirstName());
        au.setLastName(author.getLastName());
        au.setEmail(author.getEmail());
        au.setDate_of_birth(author.getDate_of_birth());
        au.setCountry(author.getCountry());
        au.setGender(author.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author id1 = entityManager.createQuery("select a from Author a where a.id = :id", Author.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public Author getAuthorByPublisherId(Long publisherId) {
        entityManager.getTransaction().begin();
        List<Author> authors = entityManager.createQuery("select a from Author a", Author.class).getResultList();
        Author authorReturn = new Author();
        for (Author author : authors) {
            for (Publisher publisher : author.getPublishers()) {
                if (Objects.equals(publisher.getId(), publisherId)){
                    authorReturn = author;
            }else {
                    System.out.println("Not found!");
                }
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return authorReturn;
    }

    @Override
    public String deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully delete";
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id = :publisherId", Publisher.class).setParameter("publisherId", publisherId).getSingleResult();
        Author author = entityManager.createQuery("select a from Author a where a.id = :authorId", Author.class).setParameter("authorId", authorId).getSingleResult();
        publisher.addAuthor(author);
        author.addPublisher(publisher);
        entityManager.merge(publisher);
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully assign.";
    }
}
