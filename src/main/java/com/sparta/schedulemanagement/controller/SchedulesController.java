package com.sparta.schedulemanagement.controller;


import com.sparta.schedulemanagement.dto.schedulesdto.CreateScheduleRequestDto;
import com.sparta.schedulemanagement.dto.schedulesdto.SchedulesResponseDto;
import com.sparta.schedulemanagement.dto.schedulesdto.UpdateScheduleRequestDto;
import com.sparta.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class SchedulesController {

    private final ScheduleService scheduleService;

    //저장
    @PostMapping
    public ResponseEntity<SchedulesResponseDto> saveToDo (@RequestBody CreateScheduleRequestDto requestDto){

        SchedulesResponseDto schedulesResponseDto = scheduleService.saveToDo(requestDto.getTitle(),
                                                                            requestDto.getContents(),
                                                                            requestDto.getAuthorName());


        return new ResponseEntity<>(schedulesResponseDto , HttpStatus.CREATED);
    }

    //단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<SchedulesResponseDto> findToDoById(@PathVariable Long id) {

        return new ResponseEntity<>(scheduleService.findToDoById(id),HttpStatus.OK);
    }

    //전체 조회
    @GetMapping
    public  ResponseEntity<List<SchedulesResponseDto>> findTodosAll() {

       return new ResponseEntity<>(scheduleService.findTodosAll(), HttpStatus.OK);
    }

    //수정(제목이나 내용)
    @PatchMapping("/{id}")
    public ResponseEntity<SchedulesResponseDto> updateTodo(@PathVariable Long id , @RequestBody UpdateScheduleRequestDto dto) {


        return new ResponseEntity<>(scheduleService.updateTodo(id, dto), HttpStatus.OK);
    }
}
