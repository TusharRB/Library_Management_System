package com.example.Library_management_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity // Make table in Db
@Table(name="author") // change name in db
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // Constructor with all attributes
@Getter
@Setter

public class Author {


    @Id // make primary key in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    // cascade => change in parent class automatically reflected in child class
    List<Book> books = new ArrayList<>(); // initialize the list because initially author not have any book
}
