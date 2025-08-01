package com.sparta.schedulemanagement.dto.commentsdto;


import com.sparta.schedulemanagement.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {

    private final Long id;

    private final String comment;

    private final String authorName;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;


    public CommentsResponseDto(Long id, String comment, String authorName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.comment = comment;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CommentsResponseDto(Comments comments) {
        this.id = comments.getId();
        this.comment =comments.getComment();
        this.authorName = comments.getAuthorName();
        this.createdAt = comments.getCreatedAt();
        this.updatedAt = comments.getUpdatedAt();

    }

    public static CommentsResponseDto toDto(Comments comments) {

        return new CommentsResponseDto(comments);
    }
}
