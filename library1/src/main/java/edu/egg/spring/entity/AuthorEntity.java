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
@Table(name = "author",indexes = {@Index(name = "idx_author_name",columnList = "author_name")})
@SQLDelete(sql="UPDATE author SET author_deleted=true WHERE author_id=?")
@Where(clause = "author_deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class AuthorEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name",length = 50,nullable = false)
    private String name;

    @Column(name = "author_deleted",columnDefinition = "BOOLEAN",nullable = false)
    private Boolean deleted;

    @Column(name = "author_up",columnDefinition = "BOOLEAN",nullable = false)
    private Boolean up;
}