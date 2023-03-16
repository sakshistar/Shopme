package com.shopme.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(length = 128, unique = true)
    private String email;

    @NonNull
    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    @NonNull
    private String lastName;

    @NonNull
    @Column(length = 64)
    private String password;

    private boolean enabled;

    private String role;

    @Column(length = 64)
    private String photos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
              )
    private Set<Role> roles = new HashSet<>();

    public User(@NonNull String email, @NonNull String firstName, @NonNull String lastName, @NonNull String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void addRoles(Role role){
        this.roles.add(role);
    }

}
