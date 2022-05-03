package edu.egg.spring.entity;

import javax.persistence.Column;

public class BookStatusEntity {
    @Column(name = "book_deleted",nullable = false)
    private Boolean deleted;

    @Column(name = "book_up",columnDefinition = "BOOLEAN",nullable = false)
    private Boolean up;
}
