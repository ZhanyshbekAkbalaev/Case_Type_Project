package peaksoft.services.impl;

import peaksoft.entity.Book;
import peaksoft.repositories.BookRepository;
import peaksoft.repositories.impl.BookRepoImpl;
import peaksoft.services.BookService;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository = new BookRepoImpl();
    @Override
    public Book saveBook(Long authorId,Long publisherId,Book book) {return bookRepository.saveBook(authorId,publisherId,book);
    }

    @Override
    public String updateBookAuthor(Long id, Book book) {
        return bookRepository.updateBookAuthor(id,book);
    }

    @Override
    public Book getBookAndPublisherByBookId(Long id) {
        return bookRepository.getBookAndPublisherByBookId(id);
    }

    @Override
    public String deleteBookByAuthorId(Long id) {
        return bookRepository.deleteBookByAuthorId(id);
    }
}
