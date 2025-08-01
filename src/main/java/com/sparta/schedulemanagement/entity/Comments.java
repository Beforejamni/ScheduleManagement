package com.sparta.schedulemanagement.entity;

import com.sparta.schedulemanagement.dto.commentsdto.CreateCommentsRequsetDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table( name = "comments")
public class Comments extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, columnDefinition = "longtext")
    private String comment;

    private String authorName;

    public Comments() {
    }

    public Comments( String comment, String authorName){
        this.comment = comment;
        this.authorName =authorName;
    }

    public Comments(CreateCommentsRequsetDto dto) {
        this.comment = dto.getComment();
        this.authorName = dto.getAuthorName();
    }

}
