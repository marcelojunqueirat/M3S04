package com.avalialivros.m3s04.model;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @Column(nullable = false, length = 36, unique = true)
    private String guid;

    @Column(nullable = false)
    private String grade; // 1 a 5

    @ManyToOne
    @JoinColumn(name = "rated_by", referencedColumnName = "guid", nullable = false)
    private Person ratedBy;

    @ManyToOne
    @JoinColumn(name = "rated_book", referencedColumnName = "guid", nullable = false)
    private Book ratedBook;
}
