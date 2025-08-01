package com.sparta.schedulemanagement.dto.commentsdto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentsRequsetDto {

    private final String comment;

    private final String authorName;

    public CreateCommentsRequsetDto(String comment, String authorName) {
        this.comment = comment;
        this.authorName = authorName;

    }
}
