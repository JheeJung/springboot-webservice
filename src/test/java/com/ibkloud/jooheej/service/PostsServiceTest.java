package com.ibkloud.jooheej.service;

import com.ibkloud.jooheej.domain.posts.Posts;
import com.ibkloud.jooheej.repository.PostsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class PostsServiceTest {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    @Rollback(value = false)
    public void savePosts() throws Exception {
        // given
        Posts posts = new Posts();

        String title = "테스트 제목";
        String content = "테스트 본문";
        String author = "테스트 저자";

        postsRepository.save( Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);

        System.out.println(post.getId());
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        System.out.println(post.getAuthor());

        post.setTitle("테스트 제목 수정");
        postsRepository.save(post);

        //when
        List<Posts> postsList1 = postsRepository.findAll();

        //then
        Posts post1 = postsList1.get(0);


        System.out.println(post1.getId());
        System.out.println(post1.getTitle());
        System.out.println(post1.getContent());
        System.out.println(post1.getAuthor());

    }


}
