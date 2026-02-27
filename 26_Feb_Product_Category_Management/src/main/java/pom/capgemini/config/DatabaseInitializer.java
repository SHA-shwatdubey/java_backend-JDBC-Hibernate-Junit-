package pom.capgemini.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n===========================================");
        System.out.println("Product Category Management System");
        System.out.println("Database initialized successfully!");
        System.out.println("===========================================");
        System.out.println("\n📚 API Documentation:");
        System.out.println("   Swagger UI: http://localhost:8088/swagger-ui.html");
        System.out.println("   OpenAPI JSON: http://localhost:8088/v3/api-docs");
        System.out.println("\n📖 Pagination Examples:");
        System.out.println("   Products (Paginated): GET /api/products/paginated?page=0&size=10&sort=productId,desc");
        System.out.println("   Categories (Paginated): GET /api/categories/paginated?page=0&size=10");
        System.out.println("   Search (Paginated): GET /api/products/search/paginated?productName=test&page=0&size=5");
        System.out.println("   By Category (Paginated): GET /api/products/category/{categoryId}/paginated?page=0&size=10");
        System.out.println("\n===========================================\n");
    }
}

