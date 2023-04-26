package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Reader;
import peaksoft.repositories.ReaderRepository;

import java.util.List;

public class ReaderRepoImpl implements ReaderRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Reader saveReader(Reader reader) {
        return null;
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return null;
    }

    @Override
    public Reader getReaderByBookId(Long id) {
        return null;
    }

    @Override
    public String deleteReaderById(Long id) {
        return null;
    }

    @Override
    public List<Reader> getReadersByAuthorId() {
        return null;
    }
}
