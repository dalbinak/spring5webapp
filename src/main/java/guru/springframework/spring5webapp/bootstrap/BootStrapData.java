package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author stephen = new Author("Stephen", "King");
        Book DarkTower = new Book("Dark Tower", "12341234");

        stephen.getBooks().add(DarkTower);
        DarkTower.getAuthors().add(stephen);

        authorRepository.save(stephen);
        bookRepository.save(DarkTower);

        Author george = new Author("George", "Orwell");
        Book AnimalFarm = new Book("Animal Farm", "43214321");
        george.getBooks().add(AnimalFarm);
        AnimalFarm.getAuthors().add(george);

        authorRepository.save(george);
        bookRepository.save(AnimalFarm);

        Publisher penguin = new Publisher("Penguin", "123 Main St", "Hollywoo", "California", "10101");



        System.out.println("Started in bootstrap.");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
