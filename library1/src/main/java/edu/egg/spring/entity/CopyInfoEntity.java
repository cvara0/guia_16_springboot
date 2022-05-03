package edu.egg.spring.entity;

import javax.persistence.Column;

public class CopyInfoEntity {

    @Column(name = "book_totalCopies",nullable = false)
    private Short totalCopies;

    @Column(name = "book_givenCopies",nullable = false)
    private Short givenCopies;

    @Column(name = "book_remainingCopies",nullable = false)
    private Short remainingCopies;

}
