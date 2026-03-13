package pom.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("🚀 Library Management System is running...");
        System.out.println("📚 Swagger UI: http://localhost:8075/swagger-ui.html");
        System.out.println("🔐 Default credentials: admin / admin123");
    }
}

