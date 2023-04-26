package peaksoft.services.impl;

import peaksoft.entity.Author;
import peaksoft.repositories.AuthorRepository;
import peaksoft.repositories.impl.AuthorRepoImpl;
import peaksoft.services.AuthorSevice;

public class AuthorServiceImpl implements AuthorSevice {
    private AuthorRepository authorRepository = new AuthorRepoImpl();

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        return authorRepository.updateAuthor(id, author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public Author getAuthorByPublisherId(Long publisherId) {
        return authorRepository.getAuthorByPublisherId(publisherId);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id);
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        return authorRepository.assignAuthorToPublisher(authorId, publisherId);
    }
}
