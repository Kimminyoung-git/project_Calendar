package com.clush.calendar.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  // JPA의 @Id 사용
import jakarta.persistence.Table;


@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 일정을 식별할 기본키

    @Column(name = "title", nullable = false)
    private String title; // 일정 제목
    
    @Column(name = "start", nullable = false)
    private Date start;    // 시작 시간
    
    @Column(name = "end", nullable = false)
    private Date end;      // 종료 시간
    
    @Column(name = "color", nullable = true)
    private String color;  // 일정 배경 색상

    // 기본 생성자
    public Event() {}

    // 생성자 (편의상 추가)
    public Event(String title, Date start, Date end, String color) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}