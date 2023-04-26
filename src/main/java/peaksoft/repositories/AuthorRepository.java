package peaksoft.repositories;

import peaksoft.entity.Author;

public interface AuthorRepository {
    Author saveAuthor(Author author);
    String updateAuthor(Long id,Author author);
    Author getAuthorById(Long id);
    Author getAuthorByPublisherId(Long publisherId);
    String deleteAuthorById(Long id);
    String assignAuthorToPublisher(Long authorId,Long publisherId);
}
