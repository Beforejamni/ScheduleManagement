package com.sparta.schedulemanagement.repository;


import com.sparta.schedulemanagement.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    default Comments findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다."));
    }

}
