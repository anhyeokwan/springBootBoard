package com.hyeongkwan.springbootboard.service;

import com.hyeongkwan.springbootboard.dto.MemberDTO;
import org.springframework.stereotype.Service;

public interface MemberService {

    public MemberDTO selectOneMember(MemberDTO memberDTO);


}
