package com.example.board_real.domain.user;

//@Slf4j
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//    /* Security */
//    private static Map<Long, User> store = new HashMap<>();   // static 사용
//    private static long sequence = 0L;  // static 사용
//
//    public User save(User user) {
//        user.setId(++sequence);
//        log.info("save: user={}", user);
//        store.put(user.getId(), user);
//        return user;
//    }
//
//    public user findById(Long id) {
//        return store.get(id);
//    }
//
//    public Optional<user> findByLoginId(String loginId) {
//        return findAll().stream()
//                .filter(m -> m.getLoginId().equals(loginId))
//                .findFirst();
//    }
//
//    public List<user> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//}