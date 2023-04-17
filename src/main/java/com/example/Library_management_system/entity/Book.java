package com.example.Library_management_system.entity;

import com.example.Library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // Make Table in Db
@Table(name="book") // change table name in db
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // Constructor with all Attributes
@Getter
@Setter

public class Book {

    @Id // make primary key table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate primary key
    private int id;

    private String title;
    private int numberOfPages;
    private int price;
    private boolean isIssued;

    @Enumerated(EnumType.STRING) // Sql understand this is enum data type
    private Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();


}
