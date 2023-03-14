package com.shopme.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

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


}
