//package com.example.board_real.web;
//
//import com.example.board_real.domain.user.User;
//import com.example.board_real.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/users")
//public class UsersController {
//    private final UserService userService;
//
//    @GetMapping("/add")
//    public String addForm(@ModelAttribute("user") User user) {
//        return "users/addUserForm";
//    }
//
//}