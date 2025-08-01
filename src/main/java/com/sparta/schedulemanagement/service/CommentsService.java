package com.sparta.schedulemanagement.service;


import com.sparta.schedulemanagement.dto.commentsdto.CommentsResponseDto;
import com.sparta.schedulemanagement.dto.commentsdto.CreateCommentsRequsetDto;
import com.sparta.schedulemanagement.entity.Comments;
import com.sparta.schedulemanagement.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentRepository commentRepository;

    public CommentsResponseDto saveComment (CreateCommentsRequsetDto dto) {

        Comments comments = new Comments(dto);

        Comments savedComments = commentRepository.save(comments);

        return new CommentsResponseDto(savedComments);
    }
}
