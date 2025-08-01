package com.sparta.schedulemanagement.dto;


import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String title;

    private final String contents;

    private final String authorName;

   public CreateScheduleRequestDto(String title, String contents, String authorName){

       this.title = title;
       this.contents = contents;
       this.authorName = authorName;
   }



}
