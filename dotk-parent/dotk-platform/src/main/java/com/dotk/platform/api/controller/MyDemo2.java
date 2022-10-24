package com.dotk.platform.api.controller;

import com.dotk.core.controller.BaseController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyDemo2 extends BaseController {

    @GetMapping("/ctrl/demo1")
    public String myDemo1() {
        return "Hello DotK!";
    }

}
