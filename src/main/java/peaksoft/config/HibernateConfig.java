package peaksoft.config;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Author;
import peaksoft.entity.Book;
import peaksoft.entity.Publisher;
import peaksoft.entity.Reader;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfig {
    public static EntityManager getEntityManager() {

        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgress");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "1234");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Reader.class);
        return configuration.buildSessionFactory().createEntityManager();
    }
}
