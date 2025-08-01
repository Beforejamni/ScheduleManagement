package com.sparta.schedulemanagement.service;


import com.sparta.schedulemanagement.dto.commentsdto.CommentsResponseDto;
import com.sparta.schedulemanagement.dto.commentsdto.CreateCommentsRequsetDto;
import com.sparta.schedulemanagement.dto.commentsdto.UpdateCommentRequestDto;
import com.sparta.schedulemanagement.entity.Comments;
import com.sparta.schedulemanagement.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentRepository commentRepository;

    public CommentsResponseDto saveComment (CreateCommentsRequsetDto dto) {

        Comments comments = new Comments(dto);

        Comments savedComments = commentRepository.save(comments);

        return new CommentsResponseDto(savedComments);
    }

    public CommentsResponseDto findCommentById(Long id) {
        
        return new CommentsResponseDto(commentRepository.findByIdOrElseThrow(id));
    }

    public List<CommentsResponseDto> findComments() {

        return commentRepository.findAll().stream().map(CommentsResponseDto ::toDto).toList();
    }

    public void deleteComment(Long id) {

        commentRepository.deleteById(id);
    }

    @Transactional
    public CommentsResponseDto updateComment(Long id, UpdateCommentRequestDto dto) {

        Comments findComment = commentRepository.findByIdOrElseThrow(id);

            findComment.updateComment(dto);


        return new CommentsResponseDto(findComment);
    }
}
