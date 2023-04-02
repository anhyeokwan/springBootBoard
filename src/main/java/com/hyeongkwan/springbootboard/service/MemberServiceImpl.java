package com.hyeongkwan.springbootboard.service;

import com.hyeongkwan.springbootboard.domain.Member;
import com.hyeongkwan.springbootboard.dto.MemberDTO;
import com.hyeongkwan.springbootboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service // service
@Log4j2 // 로깅
@RequiredArgsConstructor // Autowired 안해도 됨
@Transactional // 트랙잭션
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper; // 엔티티와 DTO간의 변환시 자동으로 오브젝트를 연결시켜주는 라이브러리

    private final MemberRepository memberRepository; // memberRepository

    @Override
    public MemberDTO selectOneMember(MemberDTO memberDTO) {

        log.info("멤버서비스임플 아이디 : " + memberDTO.getMemberId());
        log.info("멤버서비스임플 비밀번호 : " + memberDTO.getMemberPw());


        return null;
    }
}


















