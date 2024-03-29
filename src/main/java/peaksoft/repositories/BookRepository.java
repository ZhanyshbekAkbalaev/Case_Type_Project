package peaksoft.repositories;


import peaksoft.entity.Book;

public interface BookRepository {
    Book saveBook(Long authorId,Long publisherId,Book book);
    String updateBookAuthor(Long id,Book book);
    Book getBookAndPublisherByBookId(Long id);
    String deleteBookByAuthorId(Long id);
}
