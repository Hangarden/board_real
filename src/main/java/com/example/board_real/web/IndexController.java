package com.example.board_real.web;

import com.example.board_real.service.PostsService;
import com.example.board_real.web.dto.posts.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
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

    /* 글 상세보기 */
//    @GetMapping("/posts/read/{id}")
//    public String read(@PathVariable Long id, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        postsService.updateView(id); // views ++
//        model.addAttribute("posts", dto);
//        return "posts-read";
//    }

}
