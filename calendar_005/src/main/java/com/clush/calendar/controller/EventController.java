package com.clush.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clush.calendar.model.Event;
import com.clush.calendar.service.EventService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")  // 클라이언트 도메인 추가
@RestController
@RequestMapping("/calendar")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    // 이벤트 목록을 가져오는 API
    @GetMapping("/api/events")  // /calendar/api/events 경로로 이벤트를 조회
    public List<Event> getEvents() {
        return eventService.getAllEvents();  // 이벤트 목록 반환
    }
    
	
	/*
	 * // 새로운 /calendar/eventData 경로로 이벤트 목록을 가져오는 POST 요청
	 * 
	 * @PostMapping("/eventData") // 새로운 POST 경로 추가 public List<Event>
	 * getEventData() { return eventService.getAllEvents(); // 이벤트 목록 반환 } } }
	 */
		 
	 
    
    // 일정 저장
    @PostMapping()
    public Event addEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
    
	
	  // 이벤트 수정
    // PUT 요청 처리: id와 Event 객체를 받도록
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        // id와 event를 받아서 처리
        return eventService.updateEvent(id, event);
    }

    
    // 이벤트 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("이벤트 삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이벤트 삭제 실패");
        }
    }
}