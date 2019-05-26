package test1;

import test1.model.Author;
import test1.model.Book;
import test1.repozitory.AuthorRepository;
import test1.repozitory.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class Test1Run {
    public static void main(String[] args) {

        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create our repositories
        BookRepository bookRepository = new BookRepository(entityManager);
        AuthorRepository authorRepository = new AuthorRepository(entityManager);

        // Create an author and add 3 books to his list of books
        Author author = new Author("Author 1");
        author.addBook(new Book("Book 1"));
        author.addBook(new Book("Book 2"));
        author.addBook(new Book("Book 3"));
        Optional<Author> savedAuthor = authorRepository.save(author);
        System.out.println("Saved author: " + savedAuthor.get());

        // Find all authors
        List<Author> authors = authorRepository.findAll();
        System.out.println("Authors:");
        authors.forEach(System.out::println);

        // Find author by name
        Optional<Author> authorByName = authorRepository.findByName("Author 1");
        System.out.println("Searching for an author by name: ");
        authorByName.ifPresent(System.out::println);
    }


}
