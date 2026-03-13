package pom.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pom.capgemini.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAvailable(Boolean available);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    boolean existsByIsbn(String isbn);
}


