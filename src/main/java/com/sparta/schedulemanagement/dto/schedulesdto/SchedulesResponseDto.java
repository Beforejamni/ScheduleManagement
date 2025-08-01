package com.sparta.schedulemanagement.dto.schedulesdto;


import com.sparta.schedulemanagement.entity.Schedules;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulesResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final String authorName;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;


    public SchedulesResponseDto(Long id, String title, String contents, String authorName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SchedulesResponseDto(Schedules schedules) {
        this.id= schedules.getId();
        this.title = schedules.getTitle();
        this.contents = schedules.getContents();
        this.authorName = schedules.getAuthorName();
        this.createdAt = schedules.getCreatedAt();
        this.updatedAt = schedules.getUpdatedAt();

    }

    public static SchedulesResponseDto toDto(Schedules schedules) {
        return new SchedulesResponseDto(schedules.getId(),
                                        schedules.getTitle(),
                                        schedules.getContents(),
                                        schedules.getAuthorName(),
                                        schedules.getCreatedAt(),
                                        schedules.getUpdatedAt());
    }
}
