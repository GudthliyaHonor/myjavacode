package com.dotk.live.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/live/test")
    public String test2(){
        return "live test2";
    }
}
