//package com.example.board_real.web.dto.users;
//
//import com.example.board_real.domain.user.User;
//import lombok.Builder;
//
//public class UsersSaveRequestDto {
//    private String username;
//    private String nickname;
//    private String password;
//    private String email;
//
//    @Builder
//    public UsersaveRequestDto(String username, String nickname, String password, String email) {
//        this.username = username;
//        this.nickname = nickname;
//        this.password = password;
//        this.email = email;
//    }
//
//    public User toEntity() {
//        return User.builder()
//                .username(username)
//                .nickname(nickname)
//                .password(password)
//                .email(email)
//                .build();
//    }
//
//}
