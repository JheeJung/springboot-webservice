package com.ibkloud.jooheej.service;

import com.ibkloud.jooheej.domain.posts.Posts;
import com.ibkloud.jooheej.repository.PostsRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(Posts posts) {
        postsRepository.save(posts);
        return posts.getId();
    }

    public void validateDuplicatePosts(Posts posts) {
        List<Posts> findPosts = postsRepository.findByTitle(posts.getTitle());
        if(!findPosts.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 포스트입니다.");
        }
    }

    public Posts findOne(Long postsId) {
        return postsRepository.findOne(postsId);
    }

    public List<Posts> findPosts() {
        return postsRepository.findAll();
    }


}
