package com.sparta.schedulemanagement.controller;


import com.sparta.schedulemanagement.dto.memberDto.MemberRequestBody;
import com.sparta.schedulemanagement.dto.memberDto.MemberResponseBody;
import com.sparta.schedulemanagement.entity.Member;
import com.sparta.schedulemanagement.repository.MemberRepository;
import com.sparta.schedulemanagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    //유저 생성
    @PostMapping
    public ResponseEntity<MemberResponseBody> saveMember (@RequestBody MemberRequestBody dto) {
        return  new ResponseEntity<>(memberService.saveMember(dto), HttpStatus.CREATED);
    }
    //유저 단 건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseBody> findMember(@PathVariable Long id) {
        Member member = memberRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "찾을 수 없는 유저입니다."));

        return new ResponseEntity<>( new MemberResponseBody(member), HttpStatus.OK);
    }

    //유저 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberResponseBody>> findMemberList() {

       return new ResponseEntity<>(memberService.findMemberList(), HttpStatus.OK);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {

        memberRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
