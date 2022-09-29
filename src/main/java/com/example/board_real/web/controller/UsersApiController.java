package com.example.board_real.web.controller;

import com.example.board_real.domain.user.User;
import com.example.board_real.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersApiController {
    private final UserService userService;

    @PostMapping("/add")
    public String save(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/addUserForm";
        }

        userService.save(user);
        return "redirect:/";
    }
}