package com.avalialivros.m3s04.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @Column(nullable = false, length = 36, unique = true)
    private String guid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
