package com.clush.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clush.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // 필요한 추가 쿼리 메서드를 정의할 수 있습니다.
}