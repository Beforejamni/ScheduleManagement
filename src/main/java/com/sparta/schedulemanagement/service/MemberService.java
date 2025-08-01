package com.sparta.schedulemanagement.service;

import com.sparta.schedulemanagement.dto.memberDto.MemberRequestBody;
import com.sparta.schedulemanagement.dto.memberDto.MemberResponseBody;
import com.sparta.schedulemanagement.entity.Member;
import com.sparta.schedulemanagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseBody saveMember(MemberRequestBody dto) {

        Member member = new Member(dto);

        Member savedMember = memberRepository.save(member);

        return new MemberResponseBody(savedMember);
    }

    public List<MemberResponseBody> findMemberList() {

       return memberRepository.findAll().stream().map(MemberResponseBody ::todto).toList();
    }
}
