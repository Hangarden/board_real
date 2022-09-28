package com.example.board_real;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardRealApplication {
    public static void main(String[] args){
        SpringApplication.run(BoardRealApplication.class,args);
    }
}
