package com.example.board_real.domain.posts;

import com.example.board_real.domain.BaseTimeEntity;
import com.example.board_real.domain.Comment;
import com.example.board_real.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User username;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comments;
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