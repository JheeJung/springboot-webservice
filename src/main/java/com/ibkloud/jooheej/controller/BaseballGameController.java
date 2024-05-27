package com.ibkloud.jooheej.controller;

import com.ibkloud.jooheej.domain.BaseballGameItem;
import com.ibkloud.jooheej.domain.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseballGameController {

    @GetMapping("/baseballgame/domain")
    public BaseballGameItem baseballGameItem(
            @RequestParam("given") String given, // ①
            @RequestParam("input") String input) {
        return new BaseballGameItem(given, input);
    }

}
