package com.hyeongkwan.springbootboard.service;

import com.hyeongkwan.springbootboard.domain.Member;
import com.hyeongkwan.springbootboard.dto.MemberDTO;
import org.springframework.stereotype.Service;

public interface MemberService {

    MemberDTO selectOneMember(MemberDTO memberDTO);


}
