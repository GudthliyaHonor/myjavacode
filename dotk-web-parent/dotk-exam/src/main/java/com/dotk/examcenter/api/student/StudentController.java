package com.dotk.examcenter.api.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/exam/student/index")
    public String index(){
        return "/exam/student/index";
    }
}
