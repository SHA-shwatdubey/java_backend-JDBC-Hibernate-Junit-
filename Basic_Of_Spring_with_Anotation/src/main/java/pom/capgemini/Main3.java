package pom.capgemini;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MAIN3 - Constructor Injection Example (Book -> Library)
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println("MAIN3 - Constructor Injection Example\n");

        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);

        System.out.println("Spring container started.\n");

        Library library = ioc.getBean(Library.class);
        System.out.println("Constructor injection result:");
        library.showLibraryInfo();

        ioc.close();
        System.out.println("\nSpring container closed.");
    }
}

