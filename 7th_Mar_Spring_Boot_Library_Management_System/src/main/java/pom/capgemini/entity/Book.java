package pom.capgemini.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Author is required")
    @Column(nullable = false, length = 100)
    private String author;

    @NotBlank(message = "ISBN is required")
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(nullable = false)
    private Boolean available = true;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
}


