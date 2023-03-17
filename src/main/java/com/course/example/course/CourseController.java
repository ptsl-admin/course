package com.course.example.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/")
    public String greetHome(){
        return "Silence is Golden";
    }
}
