package com.clush.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {
	
	@RequestMapping("/") // 또는 원하는 경로로 수정
	public String main() {
		return "index";
	}
	
	
	@GetMapping("/modal2") public String showModal() { 
	    return "modal2"; //"modal2.html" 템플릿을 반환 
	}
	 	
}
