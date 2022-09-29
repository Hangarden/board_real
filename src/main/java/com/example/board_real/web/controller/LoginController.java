package com.example.board_real.web.controller;

import com.example.board_real.domain.user.User;
import com.example.board_real.service.LoginService;
import com.example.board_real.web.dto.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "../dto/loginForm";
        }

        User loginMember = loginService.login(form.getUsername(), form.getPassword());

        log.info("login? {}", loginMember);
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        return "redirect:/";
    }
}

