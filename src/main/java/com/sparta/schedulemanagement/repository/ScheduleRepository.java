package com.sparta.schedulemanagement.repository;


import com.sparta.schedulemanagement.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules , Long> {


    //OPtional
    default Schedules findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다."));
    }

}
