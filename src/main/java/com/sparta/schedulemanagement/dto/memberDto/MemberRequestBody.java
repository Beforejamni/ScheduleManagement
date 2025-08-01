package com.sparta.schedulemanagement.dto.memberDto;


import lombok.Getter;

@Getter
public class MemberRequestBody {

    private final String membername;

    private final String email;


    public MemberRequestBody(String membername, String email) {
        this.membername = membername;
        this.email = email;
    }
}
