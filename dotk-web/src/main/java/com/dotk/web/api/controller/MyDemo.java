package com.dotk.web.api.controller;

import com.dotk.core.annotation.Anonymous;
import com.dotk.core.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyDemo extends BaseController {


    @Anonymous
    @GetMapping("/ctrl/demo1")
    public String myDemo1() {
        return "Hello DotK!";
    }


}
