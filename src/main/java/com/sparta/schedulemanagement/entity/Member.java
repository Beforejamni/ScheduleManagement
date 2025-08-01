package com.sparta.schedulemanagement.entity;


import com.sparta.schedulemanagement.dto.memberDto.MemberRequestBody;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "members")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String membername;


    @Column(nullable = false)
    private String email;


    public Member (String membername, String email) {
        this.membername =membername;
        this.email = email;
    }

    public Member() {

    }

    public Member(MemberRequestBody dto) {
        this.membername =dto.getMembername();
        this.email = dto.getEmail();
    }
}
