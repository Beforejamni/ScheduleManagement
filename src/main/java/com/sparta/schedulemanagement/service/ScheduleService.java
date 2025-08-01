package com.sparta.schedulemanagement.service;

import com.sparta.schedulemanagement.dto.SchedulesResponseDto;
import com.sparta.schedulemanagement.dto.UpdateScheduleRequestDto;
import com.sparta.schedulemanagement.entity.Schedules;
import com.sparta.schedulemanagement.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public SchedulesResponseDto saveToDo ( String title , String contents, String authorName) {

        Schedules schedules = new Schedules(title, contents, authorName);

        Schedules savedSchedules = scheduleRepository.save(schedules);

        return new SchedulesResponseDto(savedSchedules.getId(),
                                        savedSchedules.getTitle(),
                                        savedSchedules.getContents(),
                                        savedSchedules.getAuthorName(),
                                        savedSchedules.getCreatedAt(),
                                        savedSchedules.getUpdatedAt()
        );
    }


    public SchedulesResponseDto findToDoById(Long id) {

        Schedules schedules = scheduleRepository.findByIdOrElseThrow(id);

        return new SchedulesResponseDto(schedules.getId(),
                                        schedules.getTitle(),
                                        schedules.getContents(),
                                        schedules.getAuthorName(),
                                        schedules.getCreatedAt(),
                                        schedules.getUpdatedAt());
    }

    public List<SchedulesResponseDto> findTodosAll() {

        return scheduleRepository.findAll().stream().map(SchedulesResponseDto ::toDto).toList();
    }
    @Transactional
    public SchedulesResponseDto updateTodo(Long id , UpdateScheduleRequestDto dto) {

        Schedules schedule = scheduleRepository.findByIdOrElseThrow(id);



        schedule.updateTodo(dto);

        return new SchedulesResponseDto(schedule.getId(),
                                            schedule.getTitle(),
                                            schedule.getContents(),
                                            schedule.getAuthorName(),
                                            schedule.getCreatedAt(),
                                            schedule.getUpdatedAt());
    }
}
