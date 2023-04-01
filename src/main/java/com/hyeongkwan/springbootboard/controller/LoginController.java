package com.hyeongkwan.springbootboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/loginMain")
    public String loginMain() {
        log.info("로그인 메인페이지");
        return "/login/loginMain";
    }

}
