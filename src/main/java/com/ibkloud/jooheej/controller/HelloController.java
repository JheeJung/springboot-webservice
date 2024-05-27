package com.ibkloud.jooheej.controller;

import com.ibkloud.jooheej.domain.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello"; // 화면이름
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name, // ①
            @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
