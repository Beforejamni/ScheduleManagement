package com.sparta.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table( name = "comments")
public class Comments extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "long text")
    private String comment;

    private String authorName;

    public Comments() {
    }

    public Comments(Long id , String comment, String authorName){
        this.id = id;
        this.comment = comment;
        this.authorName =authorName;
    }

}
