package com.example.board_real.service;

import com.example.board_real.domain.user.User;
import com.example.board_real.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private static Map<Long, User> store = new HashMap<>();   // static 사용
    private static long sequence = 0L;  // static 사용

    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        user.setId(++sequence);
        log.info("save: user={}", user);
        store.put(user.getId(), user); //(K key, V value)
        return userRepository.save(user);
    }

    @Transactional
    public User findById(Long id) {
        return store.get(id);
    }

    @Transactional
    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(u -> u.getId().equals(loginId))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
