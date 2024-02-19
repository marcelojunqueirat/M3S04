package com.avalialivros.m3s04.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @Column(nullable = false, length = 36, unique = true)
    private String guid;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "guid", nullable = false)
    private Person createdBy;

    @Column(nullable = false)
    private Integer yearOfPublication;

    @OneToMany(mappedBy = "ratedBook")
    private Set<Rating> grades = new HashSet<>();

}
