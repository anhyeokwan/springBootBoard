package com.hyeongkwan.springbootboard.repository.search;

import com.hyeongkwan.springbootboard.domain.Member;
import com.hyeongkwan.springbootboard.dto.MemberDTO;

import java.util.Optional;

public interface MemberSearch {
    Member login(MemberDTO memberDTO);
}
