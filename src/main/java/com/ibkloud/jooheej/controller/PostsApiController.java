package com.ibkloud.jooheej.controller;

import com.ibkloud.jooheej.domain.posts.Posts;
import com.ibkloud.jooheej.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    @Autowired
    private PostsService postsService;


    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody Posts posts){
        return postsService.save(posts);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody Posts posts) {
        return save(posts);
    }

    @GetMapping("/api/v1/posts/{id}")
    public Posts findById (@PathVariable Long id) {
        return postsService.findOne(id);
    }

}
