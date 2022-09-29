package com.example.board_real.service;

import com.example.board_real.domain.user.User;
import com.example.board_real.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;

    /**
     * @return null 로그인 실패
     */
    public User login(String loginId, String password) {
        return userService.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
