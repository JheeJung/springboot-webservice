package com.ibkloud.jooheej.controller;

import com.ibkloud.jooheej.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts", postsService.findPosts());

        return "index";
    }

    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";   // posts-save.mustache 화면 표시
    }

}
