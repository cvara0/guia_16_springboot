package edu.egg.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "publisher",indexes = {@Index(name = "idx_publisher_name",columnList = "publisher_id")})
@Setter
@Getter
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_deleted",columnDefinition = "BOOLEAN",nullable = false)
    private Boolean deleted;
}
