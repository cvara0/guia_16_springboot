package edu.egg.spring.entity;

import javax.persistence.Column;

public class BookInfoEntity {

    @Column(name = "book_isbn",nullable = false)
    private String isbn;

    @Column(name = "book_title",nullable = false)
    private String title;

    @Column(name = "book_year",nullable = false)
    private Short year;

}
