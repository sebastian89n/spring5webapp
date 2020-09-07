package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public BootstrapData(final AuthorRepository authorRepository, final BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Author eric = new Author("Eric", "Evans");
        final Book domainDrivenDesign = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(domainDrivenDesign);

        final Author rod = new Author("Rod", "Johnson");
        final Book j2EEDevelopmentWithoutEjb = new Book("J2EE Development without EJB", "125125125");
        rod.getBooks().add(j2EEDevelopmentWithoutEjb);
        j2EEDevelopmentWithoutEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(j2EEDevelopmentWithoutEjb);

        System.out.println("Started in Bootstrap");
        System.out.println("Numbers of books: " + bookRepository.count());
    }
}
