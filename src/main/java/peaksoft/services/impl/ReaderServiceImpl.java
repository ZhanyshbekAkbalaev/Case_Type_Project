package peaksoft.services.impl;

import peaksoft.entity.Reader;
import peaksoft.repositories.ReaderRepository;
import peaksoft.repositories.impl.ReaderRepoImpl;
import peaksoft.services.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ReaderRepository repository = new ReaderRepoImpl();
    @Override
    public Reader saveReader(Long bookId,Reader reader) {
        return repository.saveReader(bookId,reader);
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return repository.updateReader(id,reader);
    }

    @Override
    public Reader getReaderByBookId(Long id) {
        return repository.getReaderByBookId(id);
    }

    @Override
    public String deleteReaderById(Long id) {
        return repository.deleteReaderById(id);
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long id) {
        return repository.getReadersByAuthorId(id);
    }
}
