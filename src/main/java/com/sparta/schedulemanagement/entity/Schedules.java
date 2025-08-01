package com.sparta.schedulemanagement.entity;

import com.sparta.schedulemanagement.dto.schedulesdto.UpdateScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "schedules")
public class Schedules extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedulesId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;


    @Column(nullable = false)
    private String authorName;

    @OneToMany(mappedBy = "schedules",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> commentsList = new ArrayList<>();

    public Schedules( String title, String contents, String authorName){
        this.title = title;
        this.contents = contents;
        this.authorName = authorName;
    }

    public Schedules() {

    }

    public void updateTodo(UpdateScheduleRequestDto dto) {

        if(dto.getTitle() != null && !dto.getTitle().isBlank()) {
            this.title = dto.getTitle();
        }

        if(dto.getContents() != null && !dto.getContents().isBlank()){
            this.contents = dto.getContents();
        }
    }
}
