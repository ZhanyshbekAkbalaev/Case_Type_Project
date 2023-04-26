package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Author;
import peaksoft.entity.Publisher;
import peaksoft.repositories.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepoImpl implements PublisherRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id = :id", Publisher.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        entityManager.getTransaction().begin();
        List<Publisher> publishers = entityManager.
                createQuery("select p from Publisher p order by p.name DESC", Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;//Aty boiuncha sorttoo
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.find(Publisher.class, id);
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated.";
    }

    @Override
    public String deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name = :name",Publisher.class)
                .setParameter("name", name).getSingleResult();
        for (Author author : publisher.getAuthors()) {
            author.getPublishers().removeIf(publisher1 -> publisher1.getName().equals(name));
        }
        entityManager.remove(publisher);
//        List<Publisher> publishers = entityManager.createQuery("select p from Publisher p", Publisher.class).getResultList();
//        for (Publisher publisher : publishers) {
//            List<Author> authors = publisher.getAuthors();
//            for (Author author : authors) {
//                author.getPublishers().removeIf(publisher1 -> publisher1.getName().equals(name));
//            }
//            if(publisher.getName().equals(name)) {
//                entityManager.remove(publisher);
//            }
//        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return name + " Successfully delete";
    }
}
