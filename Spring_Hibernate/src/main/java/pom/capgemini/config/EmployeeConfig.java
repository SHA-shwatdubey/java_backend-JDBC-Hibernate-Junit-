package pom.capgemini.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class EmployeeConfig {

    @Bean
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("postgres").createEntityManager();
    }
}

