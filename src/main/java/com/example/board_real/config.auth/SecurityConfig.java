//package com.example.board_real.config.auth;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import java.net.PasswordAuthentication;
//
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근하면 권한 및 인증을 미리 체크
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    /* 시큐리티가 로그인 과정에서 password를 가로챌때 어떤 해쉬로 암호화 했는지 확인 */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
//    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web
////                .ignoring().antMatchers( "/css/**", "/js/**", "/img/**");
////    }
//
//    @Override
//        protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/css/**", "/js/**", "/img/**")
//                .permitAll()
//                .antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**")
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/auth/login")
//                .loginProcessingUrl("loginProc")
//                .defaultSuccessUrl("/")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
//    }
//
//}
