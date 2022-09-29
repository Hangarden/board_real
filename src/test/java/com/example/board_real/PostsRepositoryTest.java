package com.example.board_real;

import com.example.board_real.domain.posts.Posts;
import com.example.board_real.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach //After와 같음
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("woorong98@gmail.com")
                .build());
        //Posts
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0); //List의 첫번째 인자를 전달 받습니다.

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}