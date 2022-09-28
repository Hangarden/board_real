package com.example.board_real.domain.user;

import com.example.board_real.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, unique = true)
    private String nickname; //사용자 이름, 별명(Nickname)

    @Column(length = 100)
    private String password;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    /* 회원정보 수정 */
//    public void modify(String nickname, String password) {
//        this.nickname = nickname;
//        this.password = password;
//    }
}
