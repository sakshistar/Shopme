package com.shopme.common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    //For the ID field, need to use the @Id annotation here. And the @GeneratedValue annotation
    //to tell Hibernate that the values of this field will be generated automatically. With the strategy is
    //GenerationType.IDENTITY
   // When we specify the generation strategy as GenerationType.IDENTITY we are telling the persistence provider(hibernate) to let the database handle the auto incrementing of the id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;


    public Role(Integer id){
        this.id = id;
    }
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
