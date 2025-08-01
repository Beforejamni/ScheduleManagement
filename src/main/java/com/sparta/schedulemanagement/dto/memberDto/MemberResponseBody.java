package com.sparta.schedulemanagement.dto.memberDto;

import com.sparta.schedulemanagement.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseBody {

    private final Long id;

    private final String membername;

    private final String email;

    private final LocalDateTime createAt;

    private final LocalDateTime updatedAt;


    public MemberResponseBody(Long id, String membername, String email, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.membername = membername;
        this.email = email;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public MemberResponseBody(Member member) {
        this.id = member.getId();
        this.membername = member.getMembername();
        this.email = member.getEmail();
        this.createAt = member.getCreatedAt();
        this.updatedAt = member.getUpdatedAt();

    }

    public static MemberResponseBody todto(Member member) {

        return  new MemberResponseBody(member);
    }
}
