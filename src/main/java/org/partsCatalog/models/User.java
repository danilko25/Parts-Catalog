package org.partsCatalog.models;

import jakarta.persistence.*;
import org.partsCatalog.models.enums.UserRole;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "_USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_firstname", nullable = false)
    private String firstName;

    @Column(name = "user_lastname", nullable = false)
    private String lastName;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @ManyToMany()
    @JoinTable(
            name = "user_likedPart",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "part_id")}
    )
    private Set<Part> likedParts = new HashSet<>();


    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, UserRole userRole, Set<Part> likedParts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.likedParts = likedParts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Set<Part> getLikedParts() {
        return likedParts;
    }

    public void setLikedParts(Set<Part> likedParts) {
        this.likedParts = likedParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && userRole == user.userRole && Objects.equals(likedParts, user.likedParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, userRole);
    }
}
