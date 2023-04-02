package com.hyeongkwan.springbootboard.repository;

import com.hyeongkwan.springbootboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
