package com.example.board_real.domain.posts;

import com.example.board_real.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @Builder
    public Posts(String title, String content, String author, Integer view) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.view = view;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}