package com.sparta.schedulemanagement.service;

import com.sparta.schedulemanagement.dto.schedulesdto.SchedulesResponseDto;
import com.sparta.schedulemanagement.dto.schedulesdto.UpdateScheduleRequestDto;
import com.sparta.schedulemanagement.entity.Schedules;
import com.sparta.schedulemanagement.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    //저장
    public SchedulesResponseDto saveToDo ( String title , String contents, String authorName) {

        Schedules schedules = new Schedules(title, contents, authorName);

        Schedules savedSchedules = scheduleRepository.save(schedules);

        return new SchedulesResponseDto(savedSchedules);
    }

    //단 건 조회
    public SchedulesResponseDto findToDoById(Long id) {


        return new SchedulesResponseDto(scheduleRepository.findByIdOrElseThrow(id));
    }


    //전체 조회
    public List<SchedulesResponseDto> findTodosAll() {

        return scheduleRepository.findAll().stream().map(SchedulesResponseDto ::toDto).toList();
    }


    //댓글수정
    @Transactional
    public SchedulesResponseDto updateTodo(Long id , UpdateScheduleRequestDto dto) {

        Schedules schedule = scheduleRepository.findByIdOrElseThrow(id);

        schedule.updateTodo(dto);

        return new SchedulesResponseDto(schedule);
    }


    //페이징 처리
    public Page<SchedulesResponseDto> getPage(PageRequest pageRequest) {
        return scheduleRepository.findAll(pageRequest).map(SchedulesResponseDto :: toDto);
    }

}
