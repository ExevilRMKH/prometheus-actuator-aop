package ru.my.user.manager.users;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String login;
    private String fullName;
}
