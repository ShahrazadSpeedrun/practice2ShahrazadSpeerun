package ua.opnu.practice1_template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    private String provider;

    // Add this constructor for easy user creation without id:
    public User(String username, String password, String email, String provider) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.provider = provider;
    }
}

