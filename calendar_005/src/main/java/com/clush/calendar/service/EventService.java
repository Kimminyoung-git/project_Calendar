package com.clush.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clush.calendar.Exception.EventNotFoundException;
import com.clush.calendar.model.Event;
import com.clush.calendar.repository.EventRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    // 이벤트 생성
    public Event createEvent(Event event) {
        // 이벤트 저장
        return eventRepository.save(event); // 이벤트 객체를 DB에 저장하고 저장된 이벤트 객체 반환
    }

    // 이벤트 저장
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    
    public void updateEvent(Event updatedEvent) {
        if (updatedEvent.getEnd() == null) {
            // 기본값 설정 (예: start와 같은 날짜)
            updatedEvent.setEnd(updatedEvent.getStart());
        }

        // 데이터베이스에 이벤트 저장
        eventRepository.save(updatedEvent);
    }

    public Event updateEvent(Long id, Event event) {
        // 먼저, 데이터베이스에서 기존 이벤트 찾기
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        // 업데이트할 필드 설정
        existingEvent.setTitle(event.getTitle());
        existingEvent.setStart(event.getStart());
        existingEvent.setEnd(event.getEnd());
        existingEvent.setColor(event.getColor());

        // 업데이트된 이벤트 저장
        return eventRepository.save(existingEvent);
    }

    
    // 모든 이벤트 조회
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // 이벤트 삭제
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
        eventRepository.delete(event);
    }
}
