package com.crm.crm_backend.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;        // used as username

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    // ROLE_USER, ROLE_ADMIN
    @Column(nullable = false)
    private String role;
}
