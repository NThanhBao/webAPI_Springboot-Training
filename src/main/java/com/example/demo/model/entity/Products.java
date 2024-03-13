package com.example.demo.model.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    // Constructors, getters and setters, and other methods...
}
