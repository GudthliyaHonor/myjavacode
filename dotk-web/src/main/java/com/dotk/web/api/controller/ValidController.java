package com.dotk.web.api.controller;

import com.dotk.web.api.dto.ValidDTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Email;

@RestController
@Slf4j
@Validated
public class ValidController {

    @PostMapping("/valid/json")
    public String test1(@Validated @RequestBody ValidDTo validVO){
        log.info("validEntity is {}", validVO);
        return "/valid/json valid success";
    }

    @PostMapping("/valid/form")
    public String test2(@Validated ValidDTo validDTo){
        log.info("validEntity is {}", validDTo);
        return "/valid/form valid success";
    }


    @PostMapping(value = "/valid/query")
    public String test3(@Email String email){
        log.info("query is {}", email);
        return "query valid success";
    }

}
