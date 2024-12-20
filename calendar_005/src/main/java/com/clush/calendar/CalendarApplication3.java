package com.clush.calendar;
  
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan(basePackages = "com.clush.calendar")  // 엔티티가 포함된 패키지 추가
@ComponentScan("com.clush.calendar.**")
public class CalendarApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication3.class, args);
    }
}


