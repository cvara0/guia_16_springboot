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

    @ManyToOne
    @JoinColumn(name = "bookInfo_id",referencedColumnName = "bookInfo_id",nullable = false)
    private BookInfoEntity bookInfo;

    @ManyToOne
    @JoinColumn(name = "copyInfo_id",referencedColumnName = "copyInfo_id",nullable = false)
    private CopyInfoEntity copyInfo;
    
    @OneToOne
    @JoinColumn(name = "bookStatus_id",referencedColumnName = "bookStatus_id",nullable = false)
    private BookStatusEntity bookStatus;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "author_id",nullable = false)
    private AuthorEntity author;

    //@ManyToOne
    //@JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id",nullable = false)
    //private PublisherEntity publisher;





}
