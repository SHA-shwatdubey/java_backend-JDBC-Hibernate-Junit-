package pom.capgemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Simple bean used for constructor injection example.
 */
@Component
public class Book {

    @Value("${book.title:Spring in Action}")
    private String title;

    @Value("${book.author:Craig Walls}")
    private String author;

    @Value("${book.price:499.0}")
    private double price;

    public Book() {
        this.title = "Spring in Action";
        this.author = "Craig Walls";
        this.price = 499.0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void printBook() {
        System.out.println("Book [title=" + title + ", author=" + author + ", price=" + price + "]");
    }
}

