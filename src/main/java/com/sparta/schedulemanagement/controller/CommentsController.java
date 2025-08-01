package com.sparta.schedulemanagement.controller;


import com.sparta.schedulemanagement.dto.commentsdto.CommentsResponseDto;
import com.sparta.schedulemanagement.dto.commentsdto.CreateCommentsRequsetDto;
import com.sparta.schedulemanagement.dto.commentsdto.UpdateCommentRequestDto;
import com.sparta.schedulemanagement.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{schedules_id}/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;


    //저장 기능
    @PostMapping
    public ResponseEntity<CommentsResponseDto> saveComment (
            @PathVariable Long schedules_id,
            @RequestBody CreateCommentsRequsetDto dto) {

        CommentsResponseDto commentsResponseDto = commentsService.saveComment(dto ,schedules_id);

        return new ResponseEntity<>( commentsResponseDto, HttpStatus.CREATED);
    }

    //단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentsResponseDto> findCommentById(@PathVariable Long id) {

       return new ResponseEntity<>(commentsService.findCommentById(id), HttpStatus.OK);
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<CommentsResponseDto>> findComments() {

            commentsService.findComments();

        return new ResponseEntity<>(commentsService.findComments(),HttpStatus.OK);
    }
    //댓글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<CommentsResponseDto> updateComment(@PathVariable Long id , @RequestBody UpdateCommentRequestDto dto) {


        return new ResponseEntity<>(commentsService.updateComment(id , dto), HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {

            commentsService.deleteComment(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
