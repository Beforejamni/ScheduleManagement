package com.sparta.schedulemanagement.controller;


import com.sparta.schedulemanagement.dto.schedulesdto.CreateScheduleRequestDto;
import com.sparta.schedulemanagement.dto.schedulesdto.SchedulesResponseDto;
import com.sparta.schedulemanagement.dto.schedulesdto.UpdateScheduleRequestDto;
import com.sparta.schedulemanagement.repository.ScheduleRepository;
import com.sparta.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class SchedulesController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    //저장
    @PostMapping
    public ResponseEntity<SchedulesResponseDto> saveToDo (
            @RequestBody CreateScheduleRequestDto requestDto){

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

    //페이징네이션
    @GetMapping("/param")
    public ResponseEntity<Page<SchedulesResponseDto>> paginationToDo
        (@RequestParam(defaultValue = "0") int page ,
         @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        Page<SchedulesResponseDto> pageSchedule = scheduleService.getPage(pageRequest);

        return new ResponseEntity<>(pageSchedule , HttpStatus.OK);

    }

    //일정 삭제 -> 댓글 삭제 같이
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo( @PathVariable Long id) {

        scheduleRepository.deleteById(id);

       return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
