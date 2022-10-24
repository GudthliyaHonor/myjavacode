package com.dotk.examcenter.api.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/exam/admin/index")
    public String index(){
        return "/exam/admin/index";
    }



}
