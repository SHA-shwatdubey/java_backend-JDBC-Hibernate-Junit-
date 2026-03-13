package pom.capgemini;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MAIN4 - @Service + @Repository example
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println("MAIN4 - @Service + @Repository Example\n");

        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);

        StudentService service = ioc.getBean(StudentService.class);
        service.printStudents();

        ioc.close();
        System.out.println("\nSpring container closed.");
    }
}

