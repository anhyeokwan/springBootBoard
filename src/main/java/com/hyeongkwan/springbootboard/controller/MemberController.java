package com.hyeongkwan.springbootboard.controller;

import com.hyeongkwan.springbootboard.dto.MemberDTO;
import com.hyeongkwan.springbootboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller // 컨트롤러
@Log4j2 // 로깅
@RequestMapping("/login") // 기본경로 설정
@RequiredArgsConstructor // Autowired 안해도 됨
public class MemberController {

    private MemberService memberService;

    @GetMapping("/loginMain")
    public String loginMain() {
        log.info("로그인 메인페이지");
        return "/login/loginMain";
    }

    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpSession session) {

        log.info("member_id : " + memberDTO.getMemberId());
        log.info("member_pw : " + memberDTO.getMemberPw());

        MemberDTO mDto = memberService.selectOneMember(memberDTO);

        return "";

    }

}
