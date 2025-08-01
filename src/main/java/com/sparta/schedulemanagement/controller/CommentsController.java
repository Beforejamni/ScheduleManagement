package com.sparta.schedulemanagement.controller;


import com.sparta.schedulemanagement.dto.commentsdto.CommentsResponseDto;
import com.sparta.schedulemanagement.dto.commentsdto.CreateCommentsRequsetDto;
import com.sparta.schedulemanagement.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping
    public ResponseEntity<CommentsResponseDto> saveComment (@RequestBody CreateCommentsRequsetDto dto) {

        CommentsResponseDto commentsResponseDto = commentsService.saveComment(dto);

        return new ResponseEntity<>( commentsResponseDto, HttpStatus.OK);
    }
}
