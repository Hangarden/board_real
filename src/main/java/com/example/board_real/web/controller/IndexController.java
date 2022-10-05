package com.example.board_real.web.controller;

import com.example.board_real.domain.user.User;
import com.example.board_real.service.PostsService;
import com.example.board_real.web.dto.comments.CommentResponseDto;
import com.example.board_real.web.dto.posts.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    /* 글 상세보기 */
    @GetMapping("/posts/read/{id}")
    public String read(@PathVariable Long id, User user, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        List<CommentResponseDto> comments = dto.getComments();


        /* 댓글 관련 */
        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }

        /* 사용자 관련 */
        if (user != null) {
            model.addAttribute("user", user.getNickname());

            /* 게시글 작성자 본인인지 확인 */
            if (dto.getUserId().equals(user.getId())) {
                model.addAttribute("writer", true);
            }
        }
        postsService.updateView(id); // views ++
        model.addAttribute("posts", dto);
        return "posts/posts-read";
    }

//    쿠키값이 없는 사람도 들어 오기 때문에 required = false 로 설정
    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        postsService.updateView(id); // views ++
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/users/add")
    public String UserSave() {
        return "users/addUserForm";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }



    /* 글 상세보기 */
//    @GetMapping("/posts/read/{id}")
//    public String read(@PathVariable Long id, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        postsService.updateView(id); // views ++
//        model.addAttribute("posts", dto);
//        return "posts-read";
//    }

}
