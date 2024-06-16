package com.ibkloud.jooheej.repository;

import com.ibkloud.jooheej.domain.posts.Posts;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostsRepository {

    private final EntityManager em;

    public void save(Posts posts) {
        if(posts.getId() == null) {
            em.persist(posts);
        } else {
            em.merge(posts);
        }
    }

    public Posts findOne(Long id) {
        return em.find(Posts.class, id);
    }

    public List<Posts> findAll() {
        return em.createQuery("select p from Posts p", Posts.class)
                .getResultList();
    }

    public List<Posts> findByTitle(String title) {
        return em.createQuery("select p from Posts p where p.title = :title", Posts.class)
                .setParameter("title", title)
                .getResultList();
    }

}
