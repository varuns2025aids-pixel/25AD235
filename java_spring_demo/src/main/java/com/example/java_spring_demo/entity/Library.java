package com.example.java_spring_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`library`") // Quote the table name because LIBRARY is reserved in newer MySQL versions
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments Primary Key
    private Long id;

    private String name;
    private String location;

    public Library() {}

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
