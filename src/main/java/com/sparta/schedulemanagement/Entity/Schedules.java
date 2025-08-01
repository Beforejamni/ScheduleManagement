package com.sparta.schedulemanagement.Entity;


import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "schedules")
public class Schedules extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String context;


    @Column(nullable = false)
    private String authorname;
}
