package com.example.board_real.web.dto.posts;

import com.example.board_real.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private Integer view;


    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.view = entity.getView();
    }

//
//    public void updateVisit(Long countVisit){
//        this.countVisit = countVisit;
//    }
}
