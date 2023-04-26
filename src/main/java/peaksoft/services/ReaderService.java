package peaksoft.services;

import peaksoft.entity.Reader;

import java.util.List;

public interface ReaderService {
    Reader saveReader(Reader reader);
    String updateReader(Long id, Reader reader);
    Reader getReaderByBookId(Long id);
    String deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId();
}
