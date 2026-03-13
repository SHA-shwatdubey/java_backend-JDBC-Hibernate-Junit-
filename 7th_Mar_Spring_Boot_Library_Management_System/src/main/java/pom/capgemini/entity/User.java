package pom.capgemini.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank(message = "Full name is required")
    @Column(nullable = false, length = 100)
    private String fullName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
}


