package com.sparta.schedulemanagement.repository;


import com.sparta.schedulemanagement.entity.ConnectMemberToSchedules;
import com.sparta.schedulemanagement.entity.Member;
import com.sparta.schedulemanagement.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectMemberToSchedulesRepository  extends JpaRepository<ConnectMemberToSchedules , Long> {

    List<ConnectMemberToSchedules> findByMember(Member member);

    List<ConnectMemberToSchedules> findBySchedules(Schedules schedules);
}
