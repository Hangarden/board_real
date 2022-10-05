package com.example.board_real.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}

//    @Builder
//    public PostsUpdateRequestDto(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//}
