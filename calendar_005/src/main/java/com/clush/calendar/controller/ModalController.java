package com.clush.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModalController {

    @GetMapping("/changeEventModal.html")
    public String getChangeEventModal() {
        // templates 폴더에 위치한 changeEventModal.html을 반환
        return "changeEventModal";  // `changeEventModal.html` 파일을 반환
    }
}
