package pom.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constructor injection example using Book.
 */
@Component
public class Library {

    @Value("${library.name:City Central Library}")
    private String libraryName;

    @Value("${library.city:Delhi}")
    private String libraryCity;

    private final Book book;

    @Autowired
    public Library(Book book) {
        this.book = book;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getLibraryCity() {
        return libraryCity;
    }

    public Book getBook(){
        return book;
    }

    public void showLibraryInfo() {
        System.out.println("Library [name=" + libraryName + ", city=" + libraryCity + "]");
        System.out.println("Injected Book (constructor):");
        book.printBook();
    }
}

