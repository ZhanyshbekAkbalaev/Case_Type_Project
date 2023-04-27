package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Author;
import peaksoft.entity.Book;
import peaksoft.entity.Publisher;
import peaksoft.entity.Reader;
import peaksoft.enums.Gender;
import peaksoft.enums.Genre;
import peaksoft.services.AuthorSevice;
import peaksoft.services.BookService;
import peaksoft.services.PublisherService;
import peaksoft.services.ReaderService;
import peaksoft.services.impl.AuthorServiceImpl;
import peaksoft.services.impl.BookServiceImpl;
import peaksoft.services.impl.PublisherServiceImpl;
import peaksoft.services.impl.ReaderServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(HibernateConfig.getEntityManager());
        AuthorSevice authorSevice = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        while (true) {
            System.out.println("""
                    1-> save Author:
                    2-> update Author:
                    3-> get Author by Id:
                    4-> get Author by Publisher id:
                    5-> delete Author by id:
                    6-> assign author to publisher:
                    7-> save Publisher:
                    8-> get Publisher By id:
                    9-> get all publisher:
                    10-> update publisher:
                    11-> delete publisher by name:
                    12-> save book:
                    13-> update book author:
                    14-> get book and publisher by  book id:
                    15-> delete book by author id:
                    16-> save Reader:
                    17-> update Reader:
                    18-> get Reader by Book id:
                    19-> delete Reader by Id:
                    20-> get Readers By Author by id:""");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1:
                    System.out.println(authorSevice.saveAuthor(new Author("Chyngyz", "Aitmatov", "a@gmail.com", LocalDate.of(2004, 2, 27), "Bishkek", Gender.MALE)));
                    break;
                case 2:
                    System.out.println(authorSevice.updateAuthor(1L, new Author("Janyshbek", "Akbalaev", "j@gmail.com", LocalDate.of(1999, 3, 4), "Batken", Gender.MALE)));
                    break;
                case 3:
                    System.out.println(authorSevice.getAuthorById(1L));
                    break;
                case 4:
                    System.out.println(authorSevice.getAuthorByPublisherId(1L));
                    break;
                case 5:
                    System.out.println(authorSevice.deleteAuthorById(3L));
                    break;
                case 6:
                    System.out.println(authorSevice.assignAuthorToPublisher(1L, 1L));
                    break;
                case 7:
                    System.out.println(publisherService.savePublisher(new Publisher("Ak", "Batken")));
                    break;
                case 8:
                    System.out.println(publisherService.getPublisherById(1L));
                    break;
                case 9:
                    System.out.println(publisherService.getAllPublishers());
                    break;
                case 10:
                    System.out.println(publisherService.updatePublisher(1L, new Publisher("Chyngyz", "Jal")));
                    break;
                case 11:
                    System.out.println(publisherService.deletePublisherByName("Ak"));
                    break;
                case 12:
                    System.out.println(bookService.saveBook(1L, 1L, new Book("Sen", "Men", LocalDate.of(1287, 9, 2), 180, Genre.DRAMA)));
                    break;
                case 13:
                    System.out.println(bookService.updateBookAuthor(1L, new Book("Ak keme", "Osh", LocalDate.of(1994, 3, 7), 900, Genre.DRAMA)));
                    break;
                case 14:
                    System.out.println(bookService.getBookAndPublisherByBookId(1L));
                    break;
                case 15:
                    System.out.println(bookService.deleteBookByAuthorId(1L));
                    break;
                case 16:
                    System.out.println(readerService.saveReader(2L, new Reader("Reader", 30, "j@gmail.com")));
                    break;
                case 17:
                    System.out.println(readerService.updateReader(2L, new Reader("Baytik", 20, "b@gmail.com")));
                    break;
                case 18:
                    System.out.println(readerService.getReaderByBookId(2L));
                    break;
                case 19:
                    System.out.println(readerService.deleteReaderById(2L));
                    break;
                case 20:
                    System.out.println(readerService.getReadersByAuthorId(1L));
                    break;
                default:
                    System.out.println(num + " no!!");
            }
        }
    }
}
