package edu.egg.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book", indexes = {@Index(name = "idx_book_title", columnList = "book_title")})
@SQLDelete(sql="UPDATE book SET book_deleted=true WHERE book_id=?")
@Where(clause = "book_deleted=false")
@Getter
@Setter
@NoArgsConstructor
public class BookEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_isbn",nullable = false)
    private String isbn;

    @Column(name = "book_title",nullable = false)
    private String title;

    @Column(name = "book_year",nullable = false)
    private Short year;

    @Column(name = "book_totalCopies",nullable = false)
    private Short totalCopies;

    @Column(name = "book_givenCopies",nullable = false)
    private Short givenCopies;

    @Column(name = "book_remainingCopies",nullable = false)
    private Short remainingCopies;

    @Column(name = "book_deleted",nullable = false)
    private Boolean deleted;

    @Column(name = "book_up",columnDefinition = "BOOLEAN",nullable = false)
    private Boolean up;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "author_id",nullable = false)
    private AuthorEntity author;

    //@ManyToOne
    //@JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id",nullable = false)
    //private PublisherEntity publisher;


}
